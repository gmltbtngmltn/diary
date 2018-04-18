package edu.android.diary;

//public class MonthCalendar extends Activity {
//
//    CompactCalendarView compactCalendar;
//    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_month_calender);
//
//        final ActionBar actionbar = getSupporActionBar;
//        actionbar.setDisplayHomeAsUpEnabled(false);
//        actionbar.setTitle(null);
//
//        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
//        compactCalendar.setUseThreeLetterAbbreviation(true);
//
//        UsageEvents.Event ev1 = new UsageEvents.Event(Color.RED, 1477054800000L, "Teachers' Professional Day");
//        compactCalendar.addEvent(ev1);
//
//        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                Context context = getApplicationContext();
//
//                if (dateClicked.toString().compareTo("Fri Oct 21 09:00:00 AST 2016") == 0) {
//                    Toast.makeText(context, "Teacthers; Professional Day", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth) {
//                actionbar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
//            }
//        });
//
//    }
//
//}
