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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxInformationSource.FxInformationSourceBuilder;
import fpml.confirmation.FxInformationSource.FxInformationSourceBuilderImpl;
import fpml.confirmation.FxInformationSource.FxInformationSourceImpl;
import fpml.confirmation.InformationProvider;
import fpml.confirmation.InformationSource;
import fpml.confirmation.InformationSource.InformationSourceBuilder;
import fpml.confirmation.InformationSource.InformationSourceBuilderImpl;
import fpml.confirmation.InformationSource.InformationSourceImpl;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.meta.FxInformationSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxInformationSource", builder=FxInformationSource.FxInformationSourceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxInformationSource extends InformationSource {

	FxInformationSourceMeta metaData = new FxInformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time that the fixing will be taken along with a business center to define the time zone
	 */
	BusinessCenterTime getFixingTime();

	/*********************** Build Methods  ***********************/
	FxInformationSource build();
	
	FxInformationSource.FxInformationSourceBuilder toBuilder();
	
	static FxInformationSource.FxInformationSourceBuilder builder() {
		return new FxInformationSource.FxInformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxInformationSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxInformationSource> getType() {
		return FxInformationSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxInformationSourceBuilder extends FxInformationSource, InformationSource.InformationSourceBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxInformationSource.FxInformationSourceBuilder setRateSource(InformationProvider rateSource);
		FxInformationSource.FxInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		FxInformationSource.FxInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);
		FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime fixingTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.InformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		

		FxInformationSource.FxInformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of FxInformationSource  ***********************/
	class FxInformationSourceImpl extends InformationSource.InformationSourceImpl implements FxInformationSource {
		private final BusinessCenterTime fixingTime;
		
		protected FxInformationSourceImpl(FxInformationSource.FxInformationSourceBuilder builder) {
			super(builder);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxInformationSource build() {
			return this;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			FxInformationSource.FxInformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxInformationSource.FxInformationSourceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSource {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxInformationSource  ***********************/
	class FxInformationSourceBuilderImpl extends InformationSource.InformationSourceBuilderImpl  implements FxInformationSource.FxInformationSourceBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
	
		public FxInformationSourceBuilderImpl() {
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
		@RosettaAttribute("rateSource")
		public FxInformationSource.FxInformationSourceBuilder setRateSource(InformationProvider rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePage")
		public FxInformationSource.FxInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage) {
			this.rateSourcePage = rateSourcePage==null?null:rateSourcePage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		public FxInformationSource.FxInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading) {
			this.rateSourcePageHeading = rateSourcePageHeading==null?null:rateSourcePageHeading;
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		
		@Override
		public FxInformationSource build() {
			return new FxInformationSource.FxInformationSourceImpl(this);
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder prune() {
			super.prune();
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxInformationSource.FxInformationSourceBuilder o = (FxInformationSource.FxInformationSourceBuilder) other;
			
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSourceBuilder {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}
}
