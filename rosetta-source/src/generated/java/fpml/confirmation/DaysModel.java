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
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.CommodityDayTypeEnum;
import fpml.confirmation.DaysModel;
import fpml.confirmation.DaysModel.DaysModelBuilder;
import fpml.confirmation.DaysModel.DaysModelBuilderImpl;
import fpml.confirmation.DaysModel.DaysModelImpl;
import fpml.confirmation.DaysModelSequence0;
import fpml.confirmation.DaysModelSequence1;
import fpml.confirmation.meta.DaysModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying which days are pricing days within a pricing period. Unless a lag element is present, the pricing period will be contained within the calculation period.
 * @version ${project.version}
 */
@RosettaDataType(value="DaysModel", builder=DaysModel.DaysModelBuilderImpl.class, version="${project.version}")
public interface DaysModel extends RosettaModelObject {

	DaysModelMeta metaData = new DaysModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of day on which pricing occurs.
	 */
	CommodityDayTypeEnum getDayType();
	DaysModelSequence0 getDaysModelSequence0();
	DaysModelSequence1 getDaysModelSequence1();
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();

	/*********************** Build Methods  ***********************/
	DaysModel build();
	
	DaysModel.DaysModelBuilder toBuilder();
	
	static DaysModel.DaysModelBuilder builder() {
		return new DaysModel.DaysModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DaysModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DaysModel> getType() {
		return DaysModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("daysModelSequence0"), processor, DaysModelSequence0.class, getDaysModelSequence0());
		processRosetta(path.newSubPath("daysModelSequence1"), processor, DaysModelSequence1.class, getDaysModelSequence1());
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DaysModelBuilder extends DaysModel, RosettaModelObjectBuilder {
		DaysModelSequence0.DaysModelSequence0Builder getOrCreateDaysModelSequence0();
		DaysModelSequence0.DaysModelSequence0Builder getDaysModelSequence0();
		DaysModelSequence1.DaysModelSequence1Builder getOrCreateDaysModelSequence1();
		DaysModelSequence1.DaysModelSequence1Builder getDaysModelSequence1();
		DaysModel.DaysModelBuilder setDayType(CommodityDayTypeEnum dayType);
		DaysModel.DaysModelBuilder setDaysModelSequence0(DaysModelSequence0 daysModelSequence0);
		DaysModel.DaysModelBuilder setDaysModelSequence1(DaysModelSequence1 daysModelSequence1);
		DaysModel.DaysModelBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dayType"), CommodityDayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("daysModelSequence0"), processor, DaysModelSequence0.DaysModelSequence0Builder.class, getDaysModelSequence0());
			processRosetta(path.newSubPath("daysModelSequence1"), processor, DaysModelSequence1.DaysModelSequence1Builder.class, getDaysModelSequence1());
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		}
		

		DaysModel.DaysModelBuilder prune();
	}

	/*********************** Immutable Implementation of DaysModel  ***********************/
	class DaysModelImpl implements DaysModel {
		private final CommodityDayTypeEnum dayType;
		private final DaysModelSequence0 daysModelSequence0;
		private final DaysModelSequence1 daysModelSequence1;
		private final BusinessDayConventionEnum businessDayConvention;
		
		protected DaysModelImpl(DaysModel.DaysModelBuilder builder) {
			this.dayType = builder.getDayType();
			this.daysModelSequence0 = ofNullable(builder.getDaysModelSequence0()).map(f->f.build()).orElse(null);
			this.daysModelSequence1 = ofNullable(builder.getDaysModelSequence1()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
		}
		
		@Override
		@RosettaAttribute("dayType")
		public CommodityDayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("daysModelSequence0")
		public DaysModelSequence0 getDaysModelSequence0() {
			return daysModelSequence0;
		}
		
		@Override
		@RosettaAttribute("daysModelSequence1")
		public DaysModelSequence1 getDaysModelSequence1() {
			return daysModelSequence1;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public DaysModel build() {
			return this;
		}
		
		@Override
		public DaysModel.DaysModelBuilder toBuilder() {
			DaysModel.DaysModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DaysModel.DaysModelBuilder builder) {
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getDaysModelSequence0()).ifPresent(builder::setDaysModelSequence0);
			ofNullable(getDaysModelSequence1()).ifPresent(builder::setDaysModelSequence1);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModel _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(daysModelSequence0, _that.getDaysModelSequence0())) return false;
			if (!Objects.equals(daysModelSequence1, _that.getDaysModelSequence1())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (daysModelSequence0 != null ? daysModelSequence0.hashCode() : 0);
			_result = 31 * _result + (daysModelSequence1 != null ? daysModelSequence1.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModel {" +
				"dayType=" + this.dayType + ", " +
				"daysModelSequence0=" + this.daysModelSequence0 + ", " +
				"daysModelSequence1=" + this.daysModelSequence1 + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}

	/*********************** Builder Implementation of DaysModel  ***********************/
	class DaysModelBuilderImpl implements DaysModel.DaysModelBuilder {
	
		protected CommodityDayTypeEnum dayType;
		protected DaysModelSequence0.DaysModelSequence0Builder daysModelSequence0;
		protected DaysModelSequence1.DaysModelSequence1Builder daysModelSequence1;
		protected BusinessDayConventionEnum businessDayConvention;
	
		public DaysModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayType")
		public CommodityDayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("daysModelSequence0")
		public DaysModelSequence0.DaysModelSequence0Builder getDaysModelSequence0() {
			return daysModelSequence0;
		}
		
		@Override
		public DaysModelSequence0.DaysModelSequence0Builder getOrCreateDaysModelSequence0() {
			DaysModelSequence0.DaysModelSequence0Builder result;
			if (daysModelSequence0!=null) {
				result = daysModelSequence0;
			}
			else {
				result = daysModelSequence0 = DaysModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("daysModelSequence1")
		public DaysModelSequence1.DaysModelSequence1Builder getDaysModelSequence1() {
			return daysModelSequence1;
		}
		
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder getOrCreateDaysModelSequence1() {
			DaysModelSequence1.DaysModelSequence1Builder result;
			if (daysModelSequence1!=null) {
				result = daysModelSequence1;
			}
			else {
				result = daysModelSequence1 = DaysModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("dayType")
		public DaysModel.DaysModelBuilder setDayType(CommodityDayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("daysModelSequence0")
		public DaysModel.DaysModelBuilder setDaysModelSequence0(DaysModelSequence0 daysModelSequence0) {
			this.daysModelSequence0 = daysModelSequence0==null?null:daysModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("daysModelSequence1")
		public DaysModel.DaysModelBuilder setDaysModelSequence1(DaysModelSequence1 daysModelSequence1) {
			this.daysModelSequence1 = daysModelSequence1==null?null:daysModelSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public DaysModel.DaysModelBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		
		@Override
		public DaysModel build() {
			return new DaysModel.DaysModelImpl(this);
		}
		
		@Override
		public DaysModel.DaysModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModel.DaysModelBuilder prune() {
			if (daysModelSequence0!=null && !daysModelSequence0.prune().hasData()) daysModelSequence0 = null;
			if (daysModelSequence1!=null && !daysModelSequence1.prune().hasData()) daysModelSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDayType()!=null) return true;
			if (getDaysModelSequence0()!=null && getDaysModelSequence0().hasData()) return true;
			if (getDaysModelSequence1()!=null && getDaysModelSequence1().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModel.DaysModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DaysModel.DaysModelBuilder o = (DaysModel.DaysModelBuilder) other;
			
			merger.mergeRosetta(getDaysModelSequence0(), o.getDaysModelSequence0(), this::setDaysModelSequence0);
			merger.mergeRosetta(getDaysModelSequence1(), o.getDaysModelSequence1(), this::setDaysModelSequence1);
			
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModel _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(daysModelSequence0, _that.getDaysModelSequence0())) return false;
			if (!Objects.equals(daysModelSequence1, _that.getDaysModelSequence1())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (daysModelSequence0 != null ? daysModelSequence0.hashCode() : 0);
			_result = 31 * _result + (daysModelSequence1 != null ? daysModelSequence1.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModelBuilder {" +
				"dayType=" + this.dayType + ", " +
				"daysModelSequence0=" + this.daysModelSequence0 + ", " +
				"daysModelSequence1=" + this.daysModelSequence1 + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}
}
