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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateReference;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilder;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetImpl;
import fpml.confirmation.meta.RelativeDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 * @version ${project.version}
 */
@RosettaDataType(value="RelativeDateOffset", builder=RelativeDateOffset.RelativeDateOffsetBuilderImpl.class, version="${project.version}")
public interface RelativeDateOffset extends Offset {

	RelativeDateOffsetMeta metaData = new RelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	/**
	 * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 */
	DateReference getDateRelativeTo();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	IdentifiedDate getAdjustedDate();

	/*********************** Build Methods  ***********************/
	RelativeDateOffset build();
	
	RelativeDateOffset.RelativeDateOffsetBuilder toBuilder();
	
	static RelativeDateOffset.RelativeDateOffsetBuilder builder() {
		return new RelativeDateOffset.RelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RelativeDateOffset> getType() {
		return RelativeDateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDateOffsetBuilder extends RelativeDateOffset, Offset.OffsetBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		DateReference.DateReferenceBuilder getOrCreateDateRelativeTo();
		DateReference.DateReferenceBuilder getDateRelativeTo();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		RelativeDateOffset.RelativeDateOffsetBuilder setId(String id);
		RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(DateReference dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
		}
		

		RelativeDateOffset.RelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetImpl extends Offset.OffsetImpl implements RelativeDateOffset {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final DateReference dateRelativeTo;
		private final IdentifiedDate adjustedDate;
		
		protected RelativeDateOffsetImpl(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public DateReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public IdentifiedDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public RelativeDateOffset build() {
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			RelativeDateOffset.RelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffset {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetBuilderImpl extends Offset.OffsetBuilderImpl  implements RelativeDateOffset.RelativeDateOffsetBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected DateReference.DateReferenceBuilder dateRelativeTo;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
	
		public RelativeDateOffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
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
		@RosettaAttribute("dateRelativeTo")
		public DateReference.DateReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDateRelativeTo() {
			DateReference.DateReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public RelativeDateOffset.RelativeDateOffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateRelativeTo")
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(DateReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset build() {
			return new RelativeDateOffset.RelativeDateOffsetImpl(this);
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder prune() {
			super.prune();
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RelativeDateOffset.RelativeDateOffsetBuilder o = (RelativeDateOffset.RelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffsetBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}
}
