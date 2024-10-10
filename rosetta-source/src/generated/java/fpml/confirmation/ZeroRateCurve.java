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
import fpml.confirmation.CompoundingFrequency;
import fpml.confirmation.TermCurve;
import fpml.confirmation.ZeroRateCurve;
import fpml.confirmation.ZeroRateCurve.ZeroRateCurveBuilder;
import fpml.confirmation.ZeroRateCurve.ZeroRateCurveBuilderImpl;
import fpml.confirmation.ZeroRateCurve.ZeroRateCurveImpl;
import fpml.confirmation.meta.ZeroRateCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A curve used to model a set of zero-coupon interest rates.
 * @version ${project.version}
 */
@RosettaDataType(value="ZeroRateCurve", builder=ZeroRateCurve.ZeroRateCurveBuilderImpl.class, version="${project.version}")
public interface ZeroRateCurve extends RosettaModelObject {

	ZeroRateCurveMeta metaData = new ZeroRateCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The frequency at which the rates are compounded (e.g. continuously compounded).
	 */
	CompoundingFrequency getCompoundingFrequency();
	/**
	 * The curve of zero-coupon values.
	 */
	TermCurve getRateCurve();

	/*********************** Build Methods  ***********************/
	ZeroRateCurve build();
	
	ZeroRateCurve.ZeroRateCurveBuilder toBuilder();
	
	static ZeroRateCurve.ZeroRateCurveBuilder builder() {
		return new ZeroRateCurve.ZeroRateCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ZeroRateCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ZeroRateCurve> getType() {
		return ZeroRateCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("compoundingFrequency"), processor, CompoundingFrequency.class, getCompoundingFrequency());
		processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.class, getRateCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ZeroRateCurveBuilder extends ZeroRateCurve, RosettaModelObjectBuilder {
		CompoundingFrequency.CompoundingFrequencyBuilder getOrCreateCompoundingFrequency();
		CompoundingFrequency.CompoundingFrequencyBuilder getCompoundingFrequency();
		TermCurve.TermCurveBuilder getOrCreateRateCurve();
		TermCurve.TermCurveBuilder getRateCurve();
		ZeroRateCurve.ZeroRateCurveBuilder setCompoundingFrequency(CompoundingFrequency compoundingFrequency);
		ZeroRateCurve.ZeroRateCurveBuilder setRateCurve(TermCurve rateCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("compoundingFrequency"), processor, CompoundingFrequency.CompoundingFrequencyBuilder.class, getCompoundingFrequency());
			processRosetta(path.newSubPath("rateCurve"), processor, TermCurve.TermCurveBuilder.class, getRateCurve());
		}
		

		ZeroRateCurve.ZeroRateCurveBuilder prune();
	}

	/*********************** Immutable Implementation of ZeroRateCurve  ***********************/
	class ZeroRateCurveImpl implements ZeroRateCurve {
		private final CompoundingFrequency compoundingFrequency;
		private final TermCurve rateCurve;
		
		protected ZeroRateCurveImpl(ZeroRateCurve.ZeroRateCurveBuilder builder) {
			this.compoundingFrequency = ofNullable(builder.getCompoundingFrequency()).map(f->f.build()).orElse(null);
			this.rateCurve = ofNullable(builder.getRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compoundingFrequency")
		public CompoundingFrequency getCompoundingFrequency() {
			return compoundingFrequency;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		public TermCurve getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public ZeroRateCurve build() {
			return this;
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder toBuilder() {
			ZeroRateCurve.ZeroRateCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ZeroRateCurve.ZeroRateCurveBuilder builder) {
			ofNullable(getCompoundingFrequency()).ifPresent(builder::setCompoundingFrequency);
			ofNullable(getRateCurve()).ifPresent(builder::setRateCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ZeroRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(compoundingFrequency, _that.getCompoundingFrequency())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingFrequency != null ? compoundingFrequency.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ZeroRateCurve {" +
				"compoundingFrequency=" + this.compoundingFrequency + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}

	/*********************** Builder Implementation of ZeroRateCurve  ***********************/
	class ZeroRateCurveBuilderImpl implements ZeroRateCurve.ZeroRateCurveBuilder {
	
		protected CompoundingFrequency.CompoundingFrequencyBuilder compoundingFrequency;
		protected TermCurve.TermCurveBuilder rateCurve;
	
		public ZeroRateCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compoundingFrequency")
		public CompoundingFrequency.CompoundingFrequencyBuilder getCompoundingFrequency() {
			return compoundingFrequency;
		}
		
		@Override
		public CompoundingFrequency.CompoundingFrequencyBuilder getOrCreateCompoundingFrequency() {
			CompoundingFrequency.CompoundingFrequencyBuilder result;
			if (compoundingFrequency!=null) {
				result = compoundingFrequency;
			}
			else {
				result = compoundingFrequency = CompoundingFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCurve")
		public TermCurve.TermCurveBuilder getRateCurve() {
			return rateCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateRateCurve() {
			TermCurve.TermCurveBuilder result;
			if (rateCurve!=null) {
				result = rateCurve;
			}
			else {
				result = rateCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compoundingFrequency")
		public ZeroRateCurve.ZeroRateCurveBuilder setCompoundingFrequency(CompoundingFrequency compoundingFrequency) {
			this.compoundingFrequency = compoundingFrequency==null?null:compoundingFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rateCurve")
		public ZeroRateCurve.ZeroRateCurveBuilder setRateCurve(TermCurve rateCurve) {
			this.rateCurve = rateCurve==null?null:rateCurve.toBuilder();
			return this;
		}
		
		@Override
		public ZeroRateCurve build() {
			return new ZeroRateCurve.ZeroRateCurveImpl(this);
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder prune() {
			if (compoundingFrequency!=null && !compoundingFrequency.prune().hasData()) compoundingFrequency = null;
			if (rateCurve!=null && !rateCurve.prune().hasData()) rateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompoundingFrequency()!=null && getCompoundingFrequency().hasData()) return true;
			if (getRateCurve()!=null && getRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ZeroRateCurve.ZeroRateCurveBuilder o = (ZeroRateCurve.ZeroRateCurveBuilder) other;
			
			merger.mergeRosetta(getCompoundingFrequency(), o.getCompoundingFrequency(), this::setCompoundingFrequency);
			merger.mergeRosetta(getRateCurve(), o.getRateCurve(), this::setRateCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ZeroRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(compoundingFrequency, _that.getCompoundingFrequency())) return false;
			if (!Objects.equals(rateCurve, _that.getRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingFrequency != null ? compoundingFrequency.hashCode() : 0);
			_result = 31 * _result + (rateCurve != null ? rateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ZeroRateCurveBuilder {" +
				"compoundingFrequency=" + this.compoundingFrequency + ", " +
				"rateCurve=" + this.rateCurve +
			'}';
		}
	}
}
