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
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxSpotRateSource.FxSpotRateSourceBuilder;
import fpml.confirmation.FxSpotRateSource.FxSpotRateSourceBuilderImpl;
import fpml.confirmation.FxSpotRateSource.FxSpotRateSourceImpl;
import fpml.confirmation.InformationSource;
import fpml.confirmation.meta.FxSpotRateSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the rate source and fixing time for an fx rate.
 * @version ${project.version}
 */
@RosettaDataType(value="FxSpotRateSource", builder=FxSpotRateSource.FxSpotRateSourceBuilderImpl.class, version="${project.version}")
public interface FxSpotRateSource extends RosettaModelObject {

	FxSpotRateSourceMeta metaData = new FxSpotRateSourceMeta();

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
	 * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 */
	BusinessCenterTime getFixingTime();

	/*********************** Build Methods  ***********************/
	FxSpotRateSource build();
	
	FxSpotRateSource.FxSpotRateSourceBuilder toBuilder();
	
	static FxSpotRateSource.FxSpotRateSourceBuilder builder() {
		return new FxSpotRateSource.FxSpotRateSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSpotRateSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSpotRateSource> getType() {
		return FxSpotRateSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSpotRateSourceBuilder extends FxSpotRateSource, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		FxSpotRateSource.FxSpotRateSourceBuilder setFixingTime(BusinessCenterTime fixingTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		

		FxSpotRateSource.FxSpotRateSourceBuilder prune();
	}

	/*********************** Immutable Implementation of FxSpotRateSource  ***********************/
	class FxSpotRateSourceImpl implements FxSpotRateSource {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final BusinessCenterTime fixingTime;
		
		protected FxSpotRateSourceImpl(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxSpotRateSource build() {
			return this;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			FxSpotRateSource.FxSpotRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSource {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSpotRateSource  ***********************/
	class FxSpotRateSourceBuilderImpl implements FxSpotRateSource.FxSpotRateSourceBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
	
		public FxSpotRateSourceBuilderImpl() {
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
		@RosettaAttribute("primaryRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource primaryRateSource) {
			this.primaryRateSource = primaryRateSource==null?null:primaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("secondaryRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource secondaryRateSource) {
			this.secondaryRateSource = secondaryRateSource==null?null:secondaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public FxSpotRateSource.FxSpotRateSourceBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		
		@Override
		public FxSpotRateSource build() {
			return new FxSpotRateSource.FxSpotRateSourceImpl(this);
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSpotRateSource.FxSpotRateSourceBuilder o = (FxSpotRateSource.FxSpotRateSourceBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSourceBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}
}
