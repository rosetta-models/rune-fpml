package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CalendarSourceEnum;
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.CommodityValuationDatesSequenceSequence;
import fpml.confirmation.CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder;
import fpml.confirmation.CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilderImpl;
import fpml.confirmation.CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceImpl;
import fpml.confirmation.DaysModel;
import fpml.confirmation.meta.CommodityValuationDatesSequenceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityValuationDatesSequenceSequence", builder=CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityValuationDatesSequenceSequence extends RosettaModelObject {

	CommodityValuationDatesSequenceSequenceMeta metaData = new CommodityValuationDatesSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	DaysModel getDaysModel();
	/**
	 * Identifies a commodity business day calendar from which the pricing dates will be determined.
	 */
	CommodityBusinessCalendar getBusinessCalendar();
	/**
	 * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if “Future” is chosen, the pricing will roll to the next futures contract on expiration, if “ListedOption” is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
	 */
	CalendarSourceEnum getCalendarSource();

	/*********************** Build Methods  ***********************/
	CommodityValuationDatesSequenceSequence build();
	
	CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder toBuilder();
	
	static CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder builder() {
		return new CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityValuationDatesSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityValuationDatesSequenceSequence> getType() {
		return CommodityValuationDatesSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("daysModel"), processor, DaysModel.class, getDaysModel());
		processRosetta(path.newSubPath("businessCalendar"), processor, CommodityBusinessCalendar.class, getBusinessCalendar());
		processor.processBasic(path.newSubPath("calendarSource"), CalendarSourceEnum.class, getCalendarSource(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityValuationDatesSequenceSequenceBuilder extends CommodityValuationDatesSequenceSequence, RosettaModelObjectBuilder {
		DaysModel.DaysModelBuilder getOrCreateDaysModel();
		DaysModel.DaysModelBuilder getDaysModel();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateBusinessCalendar();
		CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getBusinessCalendar();
		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setDaysModel(DaysModel daysModel);
		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setBusinessCalendar(CommodityBusinessCalendar businessCalendar);
		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setCalendarSource(CalendarSourceEnum calendarSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("daysModel"), processor, DaysModel.DaysModelBuilder.class, getDaysModel());
			processRosetta(path.newSubPath("businessCalendar"), processor, CommodityBusinessCalendar.CommodityBusinessCalendarBuilder.class, getBusinessCalendar());
			processor.processBasic(path.newSubPath("calendarSource"), CalendarSourceEnum.class, getCalendarSource(), this);
		}
		

		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityValuationDatesSequenceSequence  ***********************/
	class CommodityValuationDatesSequenceSequenceImpl implements CommodityValuationDatesSequenceSequence {
		private final DaysModel daysModel;
		private final CommodityBusinessCalendar businessCalendar;
		private final CalendarSourceEnum calendarSource;
		
		protected CommodityValuationDatesSequenceSequenceImpl(CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder builder) {
			this.daysModel = ofNullable(builder.getDaysModel()).map(f->f.build()).orElse(null);
			this.businessCalendar = ofNullable(builder.getBusinessCalendar()).map(f->f.build()).orElse(null);
			this.calendarSource = builder.getCalendarSource();
		}
		
		@Override
		@RosettaAttribute("daysModel")
		public DaysModel getDaysModel() {
			return daysModel;
		}
		
		@Override
		@RosettaAttribute("businessCalendar")
		public CommodityBusinessCalendar getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		@RosettaAttribute("calendarSource")
		public CalendarSourceEnum getCalendarSource() {
			return calendarSource;
		}
		
		@Override
		public CommodityValuationDatesSequenceSequence build() {
			return this;
		}
		
		@Override
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder toBuilder() {
			CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder builder) {
			ofNullable(getDaysModel()).ifPresent(builder::setDaysModel);
			ofNullable(getBusinessCalendar()).ifPresent(builder::setBusinessCalendar);
			ofNullable(getCalendarSource()).ifPresent(builder::setCalendarSource);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDatesSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(daysModel, _that.getDaysModel())) return false;
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(calendarSource, _that.getCalendarSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysModel != null ? daysModel.hashCode() : 0);
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.hashCode() : 0);
			_result = 31 * _result + (calendarSource != null ? calendarSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesSequenceSequence {" +
				"daysModel=" + this.daysModel + ", " +
				"businessCalendar=" + this.businessCalendar + ", " +
				"calendarSource=" + this.calendarSource +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityValuationDatesSequenceSequence  ***********************/
	class CommodityValuationDatesSequenceSequenceBuilderImpl implements CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder {
	
		protected DaysModel.DaysModelBuilder daysModel;
		protected CommodityBusinessCalendar.CommodityBusinessCalendarBuilder businessCalendar;
		protected CalendarSourceEnum calendarSource;
	
		public CommodityValuationDatesSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("daysModel")
		public DaysModel.DaysModelBuilder getDaysModel() {
			return daysModel;
		}
		
		@Override
		public DaysModel.DaysModelBuilder getOrCreateDaysModel() {
			DaysModel.DaysModelBuilder result;
			if (daysModel!=null) {
				result = daysModel;
			}
			else {
				result = daysModel = DaysModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCalendar")
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		public CommodityBusinessCalendar.CommodityBusinessCalendarBuilder getOrCreateBusinessCalendar() {
			CommodityBusinessCalendar.CommodityBusinessCalendarBuilder result;
			if (businessCalendar!=null) {
				result = businessCalendar;
			}
			else {
				result = businessCalendar = CommodityBusinessCalendar.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calendarSource")
		public CalendarSourceEnum getCalendarSource() {
			return calendarSource;
		}
		
		@Override
		@RosettaAttribute("daysModel")
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setDaysModel(DaysModel daysModel) {
			this.daysModel = daysModel==null?null:daysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCalendar")
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setBusinessCalendar(CommodityBusinessCalendar businessCalendar) {
			this.businessCalendar = businessCalendar==null?null:businessCalendar.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calendarSource")
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder setCalendarSource(CalendarSourceEnum calendarSource) {
			this.calendarSource = calendarSource==null?null:calendarSource;
			return this;
		}
		
		@Override
		public CommodityValuationDatesSequenceSequence build() {
			return new CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceImpl(this);
		}
		
		@Override
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder prune() {
			if (daysModel!=null && !daysModel.prune().hasData()) daysModel = null;
			if (businessCalendar!=null && !businessCalendar.prune().hasData()) businessCalendar = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDaysModel()!=null && getDaysModel().hasData()) return true;
			if (getBusinessCalendar()!=null && getBusinessCalendar().hasData()) return true;
			if (getCalendarSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder o = (CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder) other;
			
			merger.mergeRosetta(getDaysModel(), o.getDaysModel(), this::setDaysModel);
			merger.mergeRosetta(getBusinessCalendar(), o.getBusinessCalendar(), this::setBusinessCalendar);
			
			merger.mergeBasic(getCalendarSource(), o.getCalendarSource(), this::setCalendarSource);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDatesSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(daysModel, _that.getDaysModel())) return false;
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(calendarSource, _that.getCalendarSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysModel != null ? daysModel.hashCode() : 0);
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.hashCode() : 0);
			_result = 31 * _result + (calendarSource != null ? calendarSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesSequenceSequenceBuilder {" +
				"daysModel=" + this.daysModel + ", " +
				"businessCalendar=" + this.businessCalendar + ", " +
				"calendarSource=" + this.calendarSource +
			'}';
		}
	}
}
