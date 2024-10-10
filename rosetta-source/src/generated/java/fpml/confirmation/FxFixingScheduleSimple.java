package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder;
import fpml.confirmation.FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl;
import fpml.confirmation.FxFixingScheduleSimple.FxFixingScheduleSimpleImpl;
import fpml.confirmation.FxFixingScheduleSimpleSequence;
import fpml.confirmation.meta.FxFixingScheduleSimpleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes the FX fixing schedule, a single continuous observation period which follows the applicable business day schedule for the quoted rate source.
 * @version ${project.version}
 */
@RosettaDataType(value="FxFixingScheduleSimple", builder=FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl.class, version="${project.version}")
public interface FxFixingScheduleSimple extends RosettaModelObject {

	FxFixingScheduleSimpleMeta metaData = new FxFixingScheduleSimpleMeta();

	/*********************** Getter Methods  ***********************/
	FxFixingScheduleSimpleSequence getFxFixingScheduleSimpleSequence();
	/**
	 * The end of the period over which observations are made to determine whether a trigger event has occurred.
	 */
	Date getEndDate();
	/**
	 * Specifies whether the schedule follows the business or calendar days.
	 */
	DayTypeEnum getDayType();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	/**
	 * An explicit list of dates in the schedule. For documentation purpose only.
	 */
	List<Date> getFixingDate();

	/*********************** Build Methods  ***********************/
	FxFixingScheduleSimple build();
	
	FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder();
	
	static FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder() {
		return new FxFixingScheduleSimple.FxFixingScheduleSimpleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingScheduleSimple> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingScheduleSimple> getType() {
		return FxFixingScheduleSimple.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxFixingScheduleSimpleSequence"), processor, FxFixingScheduleSimpleSequence.class, getFxFixingScheduleSimpleSequence());
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleSimpleBuilder extends FxFixingScheduleSimple, RosettaModelObjectBuilder {
		FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder getOrCreateFxFixingScheduleSimpleSequence();
		FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder getFxFixingScheduleSimpleSequence();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFxFixingScheduleSimpleSequence(FxFixingScheduleSimpleSequence fxFixingScheduleSimpleSequence);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setEndDate(Date endDate);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setDayType(DayTypeEnum dayType);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(Date fixingDate0);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(Date fixingDate1, int _idx);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(List<Date> fixingDate2);
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFixingDate(List<Date> fixingDate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxFixingScheduleSimpleSequence"), processor, FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder.class, getFxFixingScheduleSimpleSequence());
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		}
		

		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingScheduleSimple  ***********************/
	class FxFixingScheduleSimpleImpl implements FxFixingScheduleSimple {
		private final FxFixingScheduleSimpleSequence fxFixingScheduleSimpleSequence;
		private final Date endDate;
		private final DayTypeEnum dayType;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final List<Date> fixingDate;
		
		protected FxFixingScheduleSimpleImpl(FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder) {
			this.fxFixingScheduleSimpleSequence = ofNullable(builder.getFxFixingScheduleSimpleSequence()).map(f->f.build()).orElse(null);
			this.endDate = builder.getEndDate();
			this.dayType = builder.getDayType();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSimpleSequence")
		public FxFixingScheduleSimpleSequence getFxFixingScheduleSimpleSequence() {
			return fxFixingScheduleSimpleSequence;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public FxFixingScheduleSimple build() {
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder() {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder builder) {
			ofNullable(getFxFixingScheduleSimpleSequence()).ifPresent(builder::setFxFixingScheduleSimpleSequence);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimple _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingScheduleSimpleSequence, _that.getFxFixingScheduleSimpleSequence())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingScheduleSimpleSequence != null ? fxFixingScheduleSimpleSequence.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimple {" +
				"fxFixingScheduleSimpleSequence=" + this.fxFixingScheduleSimpleSequence + ", " +
				"endDate=" + this.endDate + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingScheduleSimple  ***********************/
	class FxFixingScheduleSimpleBuilderImpl implements FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder {
	
		protected FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder fxFixingScheduleSimpleSequence;
		protected Date endDate;
		protected DayTypeEnum dayType;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected List<Date> fixingDate = new ArrayList<>();
	
		public FxFixingScheduleSimpleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxFixingScheduleSimpleSequence")
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder getFxFixingScheduleSimpleSequence() {
			return fxFixingScheduleSimpleSequence;
		}
		
		@Override
		public FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder getOrCreateFxFixingScheduleSimpleSequence() {
			FxFixingScheduleSimpleSequence.FxFixingScheduleSimpleSequenceBuilder result;
			if (fxFixingScheduleSimpleSequence!=null) {
				result = fxFixingScheduleSimpleSequence;
			}
			else {
				result = fxFixingScheduleSimpleSequence = FxFixingScheduleSimpleSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSimpleSequence")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFxFixingScheduleSimpleSequence(FxFixingScheduleSimpleSequence fxFixingScheduleSimpleSequence) {
			this.fxFixingScheduleSimpleSequence = fxFixingScheduleSimpleSequence==null?null:fxFixingScheduleSimpleSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(Date fixingDate) {
			if (fixingDate!=null) this.fixingDate.add(fixingDate);
			return this;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(Date fixingDate, int _idx) {
			getIndex(this.fixingDate, _idx, () -> fixingDate);
			return this;
		}
		@Override 
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder addFixingDate(List<Date> fixingDates) {
			if (fixingDates != null) {
				for (Date toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixingDate")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder setFixingDate(List<Date> fixingDates) {
			if (fixingDates == null)  {
				this.fixingDate = new ArrayList<>();
			}
			else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxFixingScheduleSimple build() {
			return new FxFixingScheduleSimple.FxFixingScheduleSimpleImpl(this);
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder prune() {
			if (fxFixingScheduleSimpleSequence!=null && !fxFixingScheduleSimpleSequence.prune().hasData()) fxFixingScheduleSimpleSequence = null;
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxFixingScheduleSimpleSequence()!=null && getFxFixingScheduleSimpleSequence().hasData()) return true;
			if (getEndDate()!=null) return true;
			if (getDayType()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder o = (FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder) other;
			
			merger.mergeRosetta(getFxFixingScheduleSimpleSequence(), o.getFxFixingScheduleSimpleSequence(), this::setFxFixingScheduleSimpleSequence);
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<Date>) this::addFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSimple _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingScheduleSimpleSequence, _that.getFxFixingScheduleSimpleSequence())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingScheduleSimpleSequence != null ? fxFixingScheduleSimpleSequence.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSimpleBuilder {" +
				"fxFixingScheduleSimpleSequence=" + this.fxFixingScheduleSimpleSequence + ", " +
				"endDate=" + this.endDate + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}
}
