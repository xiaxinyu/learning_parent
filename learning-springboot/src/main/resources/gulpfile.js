const gulp = require('gulp'),
      uglify = require('gulp-uglify'),
      rename = require('gulp-rename'),
      concat = require('gulp-concat'),
      gulpif = require('gulp-if'),
      beautify = require('gulp-beautify'),
      filter = require('gulp-filter');

/***********************************************************************/
/* App Directory */
/***********************************************************************/
const projectRoot = './static';

const devPath = {
    'js'        : projectRoot + '/landingpage/js/',
    'jsCommon'  : projectRoot + '/common/js/'
};

const dist = projectRoot + '/landingpage';
const distPath = {
    'js' : dist + '/js'
};

/***********************************************************************/
/* Gulp Tasks */
/***********************************************************************/
gulp.task('beautify-js', function(){
	var jsName = 'lp-all';
    gulp.src([devPath.js + '*', '!' + devPath.js + jsName + '.min.js'])
    	   .pipe(beautify())
           .pipe(gulp.dest(devPath.js));
    
    gulp.src([devPath.jsCommon + '*'])
	   .pipe(beautify())
    .pipe(gulp.dest(devPath.jsCommon)); 
});

gulp.task('build-js', function(){
	var jsName = 'lp-all';
    return gulp.src([devPath.js + '*', devPath.jsCommon + '*', '!' + devPath.js + jsName + '.min.js'])
    	   .pipe(uglify())
           .pipe(concat(jsName + '.js', {newLine:'\n'}))
           .pipe(rename({suffix: '.min'}))
           .pipe(filter('**/' + jsName + '.min.js', {restore: true}))
           .pipe(gulp.dest(distPath.js));
});

/***********************************************************************/
/* Gulp watchs */
/***********************************************************************/
gulp.task('watch', function () {
    gulp.watch(devPath.js, ['build-js',]).on('change', function(event){
        console.log('File ' + event.path + ' was ' + event.type + ', running tasks...');
    });
});