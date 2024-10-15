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
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.InterestShortFall;
import fpml.confirmation.InterestShortFall.InterestShortFallBuilder;
import fpml.confirmation.InterestShortFall.InterestShortFallBuilderImpl;
import fpml.confirmation.InterestShortFall.InterestShortFallImpl;
import fpml.confirmation.InterestShortfallCapEnum;
import fpml.confirmation.meta.InterestShortFallMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestShortFall", builder=InterestShortFall.InterestShortFallBuilderImpl.class, version="${project.version}")
public interface InterestShortFall extends RosettaModelObject {

	InterestShortFallMeta metaData = new InterestShortFallMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
	 */
	InterestShortfallCapEnum getInterestShortfallCap();
	Boolean getCompounding();
	/**
	 * The rate source in the case of a variable cap.
	 */
	FloatingRateIndex getRateSource();

	/*********************** Build Methods  ***********************/
	InterestShortFall build();
	
	InterestShortFall.InterestShortFallBuilder toBuilder();
	
	static InterestShortFall.InterestShortFallBuilder builder() {
		return new InterestShortFall.InterestShortFallBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestShortFall> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestShortFall> getType() {
		return InterestShortFall.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("interestShortfallCap"), InterestShortfallCapEnum.class, getInterestShortfallCap(), this);
		processor.processBasic(path.newSubPath("compounding"), Boolean.class, getCompounding(), this);
		processRosetta(path.newSubPath("rateSource"), processor, FloatingRateIndex.class, getRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestShortFallBuilder extends InterestShortFall, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateRateSource();
		FloatingRateIndex.FloatingRateIndexBuilder getRateSource();
		InterestShortFall.InterestShortFallBuilder setInterestShortfallCap(InterestShortfallCapEnum interestShortfallCap);
		InterestShortFall.InterestShortFallBuilder setCompounding(Boolean compounding);
		InterestShortFall.InterestShortFallBuilder setRateSource(FloatingRateIndex rateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("interestShortfallCap"), InterestShortfallCapEnum.class, getInterestShortfallCap(), this);
			processor.processBasic(path.newSubPath("compounding"), Boolean.class, getCompounding(), this);
			processRosetta(path.newSubPath("rateSource"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getRateSource());
		}
		

		InterestShortFall.InterestShortFallBuilder prune();
	}

	/*********************** Immutable Implementation of InterestShortFall  ***********************/
	class InterestShortFallImpl implements InterestShortFall {
		private final InterestShortfallCapEnum interestShortfallCap;
		private final Boolean compounding;
		private final FloatingRateIndex rateSource;
		
		protected InterestShortFallImpl(InterestShortFall.InterestShortFallBuilder builder) {
			this.interestShortfallCap = builder.getInterestShortfallCap();
			this.compounding = builder.getCompounding();
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestShortfallCap")
		public InterestShortfallCapEnum getInterestShortfallCap() {
			return interestShortfallCap;
		}
		
		@Override
		@RosettaAttribute("compounding")
		public Boolean getCompounding() {
			return compounding;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public FloatingRateIndex getRateSource() {
			return rateSource;
		}
		
		@Override
		public InterestShortFall build() {
			return this;
		}
		
		@Override
		public InterestShortFall.InterestShortFallBuilder toBuilder() {
			InterestShortFall.InterestShortFallBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestShortFall.InterestShortFallBuilder builder) {
			ofNullable(getInterestShortfallCap()).ifPresent(builder::setInterestShortfallCap);
			ofNullable(getCompounding()).ifPresent(builder::setCompounding);
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestShortFall _that = getType().cast(o);
		
			if (!Objects.equals(interestShortfallCap, _that.getInterestShortfallCap())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestShortfallCap != null ? interestShortfallCap.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestShortFall {" +
				"interestShortfallCap=" + this.interestShortfallCap + ", " +
				"compounding=" + this.compounding + ", " +
				"rateSource=" + this.rateSource +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestShortFall  ***********************/
	class InterestShortFallBuilderImpl implements InterestShortFall.InterestShortFallBuilder {
	
		protected InterestShortfallCapEnum interestShortfallCap;
		protected Boolean compounding;
		protected FloatingRateIndex.FloatingRateIndexBuilder rateSource;
	
		public InterestShortFallBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interestShortfallCap")
		public InterestShortfallCapEnum getInterestShortfallCap() {
			return interestShortfallCap;
		}
		
		@Override
		@RosettaAttribute("compounding")
		public Boolean getCompounding() {
			return compounding;
		}
		
		@Override
		@RosettaAttribute("rateSource")
		public FloatingRateIndex.FloatingRateIndexBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateRateSource() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestShortfallCap")
		public InterestShortFall.InterestShortFallBuilder setInterestShortfallCap(InterestShortfallCapEnum interestShortfallCap) {
			this.interestShortfallCap = interestShortfallCap==null?null:interestShortfallCap;
			return this;
		}
		@Override
		@RosettaAttribute("compounding")
		public InterestShortFall.InterestShortFallBuilder setCompounding(Boolean compounding) {
			this.compounding = compounding==null?null:compounding;
			return this;
		}
		@Override
		@RosettaAttribute("rateSource")
		public InterestShortFall.InterestShortFallBuilder setRateSource(FloatingRateIndex rateSource) {
			this.rateSource = rateSource==null?null:rateSource.toBuilder();
			return this;
		}
		
		@Override
		public InterestShortFall build() {
			return new InterestShortFall.InterestShortFallImpl(this);
		}
		
		@Override
		public InterestShortFall.InterestShortFallBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestShortFall.InterestShortFallBuilder prune() {
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterestShortfallCap()!=null) return true;
			if (getCompounding()!=null) return true;
			if (getRateSource()!=null && getRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestShortFall.InterestShortFallBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestShortFall.InterestShortFallBuilder o = (InterestShortFall.InterestShortFallBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			
			merger.mergeBasic(getInterestShortfallCap(), o.getInterestShortfallCap(), this::setInterestShortfallCap);
			merger.mergeBasic(getCompounding(), o.getCompounding(), this::setCompounding);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestShortFall _that = getType().cast(o);
		
			if (!Objects.equals(interestShortfallCap, _that.getInterestShortfallCap())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestShortfallCap != null ? interestShortfallCap.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestShortFallBuilder {" +
				"interestShortfallCap=" + this.interestShortfallCap + ", " +
				"compounding=" + this.compounding + ", " +
				"rateSource=" + this.rateSource +
			'}';
		}
	}
}
