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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDateRange;
import fpml.confirmation.BusinessDateRange.BusinessDateRangeBuilder;
import fpml.confirmation.BusinessDateRange.BusinessDateRangeBuilderImpl;
import fpml.confirmation.BusinessDateRange.BusinessDateRangeImpl;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateRange;
import fpml.confirmation.DateRange.DateRangeBuilder;
import fpml.confirmation.DateRange.DateRangeBuilderImpl;
import fpml.confirmation.DateRange.DateRangeImpl;
import fpml.confirmation.meta.BusinessDateRangeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BusinessDateRange", builder=BusinessDateRange.BusinessDateRangeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BusinessDateRange extends DateRange {

	BusinessDateRangeMeta metaData = new BusinessDateRangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();

	/*********************** Build Methods  ***********************/
	BusinessDateRange build();
	
	BusinessDateRange.BusinessDateRangeBuilder toBuilder();
	
	static BusinessDateRange.BusinessDateRangeBuilder builder() {
		return new BusinessDateRange.BusinessDateRangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessDateRange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessDateRange> getType() {
		return BusinessDateRange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedFirstDate"), Date.class, getUnadjustedFirstDate(), this);
		processor.processBasic(path.newSubPath("unadjustedLastDate"), Date.class, getUnadjustedLastDate(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessDateRangeBuilder extends BusinessDateRange, DateRange.DateRangeBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate);
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedFirstDate"), Date.class, getUnadjustedFirstDate(), this);
			processor.processBasic(path.newSubPath("unadjustedLastDate"), Date.class, getUnadjustedLastDate(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
		}
		

		BusinessDateRange.BusinessDateRangeBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessDateRange  ***********************/
	class BusinessDateRangeImpl extends DateRange.DateRangeImpl implements BusinessDateRange {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		
		protected BusinessDateRangeImpl(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
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
		public BusinessDateRange build() {
			return this;
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			BusinessDateRange.BusinessDateRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRange {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessDateRange  ***********************/
	class BusinessDateRangeBuilderImpl extends DateRange.DateRangeBuilderImpl  implements BusinessDateRange.BusinessDateRangeBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
	
		public BusinessDateRangeBuilderImpl() {
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
		@RosettaAttribute("unadjustedFirstDate")
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate) {
			this.unadjustedFirstDate = unadjustedFirstDate==null?null:unadjustedFirstDate;
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedLastDate")
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate) {
			this.unadjustedLastDate = unadjustedLastDate==null?null:unadjustedLastDate;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public BusinessDateRange build() {
			return new BusinessDateRange.BusinessDateRangeImpl(this);
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder prune() {
			super.prune();
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BusinessDateRange.BusinessDateRangeBuilder o = (BusinessDateRange.BusinessDateRangeBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRangeBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}
}
