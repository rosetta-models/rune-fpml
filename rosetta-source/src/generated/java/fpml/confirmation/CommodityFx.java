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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityFx.CommodityFxBuilder;
import fpml.confirmation.CommodityFx.CommodityFxBuilderImpl;
import fpml.confirmation.CommodityFx.CommodityFxImpl;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.CommodityFxType;
import fpml.confirmation.InformationSource;
import fpml.confirmation.meta.CommodityFxMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency. The rate source must be specified. Additionally, a time for the spot price to be observed on that source may be specified, or else an averaging schedule for trades priced using an average FX rate.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFx", builder=CommodityFx.CommodityFxBuilderImpl.class, version="${project.version}")
public interface CommodityFx extends RosettaModelObject {

	CommodityFxMeta metaData = new CommodityFxMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getPrimaryRateSource();
	/**
	 * An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getSecondaryRateSource();
	/**
	 * A type to identify how the FX rate will be applied. This is intended to differentiate between the various methods for applying FX to the floating price such as a daily calculation, or averaging the FX and applying the average at the end of each CalculationPeriod.
	 */
	CommodityFxType getFxType();
	/**
	 * The parties may specify a Method of Averaging when averaging of the FX rate is applicable.
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 * The time at which the spot currency exchange rate will be observed. It is specified as a time in a specific business center, e.g. 11:00am London time.
	 */
	BusinessCenterTime getFixingTime();
	CommodityFxSequence getCommodityFxSequence();

	/*********************** Build Methods  ***********************/
	CommodityFx build();
	
	CommodityFx.CommodityFxBuilder toBuilder();
	
	static CommodityFx.CommodityFxBuilder builder() {
		return new CommodityFx.CommodityFxBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFx> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFx> getType() {
		return CommodityFx.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fxType"), processor, CommodityFxType.class, getFxType());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("commodityFxSequence"), processor, CommodityFxSequence.class, getCommodityFxSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxBuilder extends CommodityFx, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		CommodityFxType.CommodityFxTypeBuilder getOrCreateFxType();
		CommodityFxType.CommodityFxTypeBuilder getFxType();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		CommodityFxSequence.CommodityFxSequenceBuilder getOrCreateCommodityFxSequence();
		CommodityFxSequence.CommodityFxSequenceBuilder getCommodityFxSequence();
		CommodityFx.CommodityFxBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		CommodityFx.CommodityFxBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		CommodityFx.CommodityFxBuilder setFxType(CommodityFxType fxType);
		CommodityFx.CommodityFxBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityFx.CommodityFxBuilder setFixingTime(BusinessCenterTime fixingTime);
		CommodityFx.CommodityFxBuilder setCommodityFxSequence(CommodityFxSequence commodityFxSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fxType"), processor, CommodityFxType.CommodityFxTypeBuilder.class, getFxType());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("commodityFxSequence"), processor, CommodityFxSequence.CommodityFxSequenceBuilder.class, getCommodityFxSequence());
		}
		

		CommodityFx.CommodityFxBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFx  ***********************/
	class CommodityFxImpl implements CommodityFx {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final CommodityFxType fxType;
		private final AveragingMethodEnum averagingMethod;
		private final BusinessCenterTime fixingTime;
		private final CommodityFxSequence commodityFxSequence;
		
		protected CommodityFxImpl(CommodityFx.CommodityFxBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fxType = ofNullable(builder.getFxType()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.commodityFxSequence = ofNullable(builder.getCommodityFxSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("fxType")
		public CommodityFxType getFxType() {
			return fxType;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("commodityFxSequence")
		public CommodityFxSequence getCommodityFxSequence() {
			return commodityFxSequence;
		}
		
		@Override
		public CommodityFx build() {
			return this;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder toBuilder() {
			CommodityFx.CommodityFxBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFx.CommodityFxBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFxType()).ifPresent(builder::setFxType);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getCommodityFxSequence()).ifPresent(builder::setCommodityFxSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFx _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(commodityFxSequence, _that.getCommodityFxSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (commodityFxSequence != null ? commodityFxSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFx {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fxType=" + this.fxType + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"commodityFxSequence=" + this.commodityFxSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFx  ***********************/
	class CommodityFxBuilderImpl implements CommodityFx.CommodityFxBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected CommodityFxType.CommodityFxTypeBuilder fxType;
		protected AveragingMethodEnum averagingMethod;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected CommodityFxSequence.CommodityFxSequenceBuilder commodityFxSequence;
	
		public CommodityFxBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("primaryRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxType")
		public CommodityFxType.CommodityFxTypeBuilder getFxType() {
			return fxType;
		}
		
		@Override
		public CommodityFxType.CommodityFxTypeBuilder getOrCreateFxType() {
			CommodityFxType.CommodityFxTypeBuilder result;
			if (fxType!=null) {
				result = fxType;
			}
			else {
				result = fxType = CommodityFxType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFxSequence")
		public CommodityFxSequence.CommodityFxSequenceBuilder getCommodityFxSequence() {
			return commodityFxSequence;
		}
		
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder getOrCreateCommodityFxSequence() {
			CommodityFxSequence.CommodityFxSequenceBuilder result;
			if (commodityFxSequence!=null) {
				result = commodityFxSequence;
			}
			else {
				result = commodityFxSequence = CommodityFxSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public CommodityFx.CommodityFxBuilder setPrimaryRateSource(InformationSource primaryRateSource) {
			this.primaryRateSource = primaryRateSource==null?null:primaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("secondaryRateSource")
		public CommodityFx.CommodityFxBuilder setSecondaryRateSource(InformationSource secondaryRateSource) {
			this.secondaryRateSource = secondaryRateSource==null?null:secondaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxType")
		public CommodityFx.CommodityFxBuilder setFxType(CommodityFxType fxType) {
			this.fxType = fxType==null?null:fxType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public CommodityFx.CommodityFxBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public CommodityFx.CommodityFxBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFxSequence")
		public CommodityFx.CommodityFxBuilder setCommodityFxSequence(CommodityFxSequence commodityFxSequence) {
			this.commodityFxSequence = commodityFxSequence==null?null:commodityFxSequence.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFx build() {
			return new CommodityFx.CommodityFxImpl(this);
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFx.CommodityFxBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fxType!=null && !fxType.prune().hasData()) fxType = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (commodityFxSequence!=null && !commodityFxSequence.prune().hasData()) commodityFxSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFxType()!=null && getFxType().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getCommodityFxSequence()!=null && getCommodityFxSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFx.CommodityFxBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFx.CommodityFxBuilder o = (CommodityFx.CommodityFxBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFxType(), o.getFxType(), this::setFxType);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getCommodityFxSequence(), o.getCommodityFxSequence(), this::setCommodityFxSequence);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFx _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fxType, _that.getFxType())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(commodityFxSequence, _that.getCommodityFxSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fxType != null ? fxType.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (commodityFxSequence != null ? commodityFxSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fxType=" + this.fxType + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"commodityFxSequence=" + this.commodityFxSequence +
			'}';
		}
	}
}
