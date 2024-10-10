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
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder;
import fpml.confirmation.NoTouchRateObservationSequence0.NoTouchRateObservationSequence0BuilderImpl;
import fpml.confirmation.NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Impl;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import fpml.confirmation.meta.NoTouchRateObservationSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchRateObservationSequence0", builder=NoTouchRateObservationSequence0.NoTouchRateObservationSequence0BuilderImpl.class, version="${project.version}")
public interface NoTouchRateObservationSequence0 extends RosettaModelObject {

	NoTouchRateObservationSequence0Meta metaData = new NoTouchRateObservationSequence0Meta();

	/*********************** Getter Methods  ***********************/
	NoTouchLowerBarrierObservation getLowerBarrier();
	NoTouchUpperBarrierObservation getUpperBarrier();

	/*********************** Build Methods  ***********************/
	NoTouchRateObservationSequence0 build();
	
	NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder toBuilder();
	
	static NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder builder() {
		return new NoTouchRateObservationSequence0.NoTouchRateObservationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchRateObservationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchRateObservationSequence0> getType() {
		return NoTouchRateObservationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lowerBarrier"), processor, NoTouchLowerBarrierObservation.class, getLowerBarrier());
		processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.class, getUpperBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchRateObservationSequence0Builder extends NoTouchRateObservationSequence0, RosettaModelObjectBuilder {
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getOrCreateLowerBarrier();
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getLowerBarrier();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier();
		NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder setLowerBarrier(NoTouchLowerBarrierObservation lowerBarrier);
		NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder setUpperBarrier(NoTouchUpperBarrierObservation upperBarrier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lowerBarrier"), processor, NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder.class, getLowerBarrier());
			processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder.class, getUpperBarrier());
		}
		

		NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of NoTouchRateObservationSequence0  ***********************/
	class NoTouchRateObservationSequence0Impl implements NoTouchRateObservationSequence0 {
		private final NoTouchLowerBarrierObservation lowerBarrier;
		private final NoTouchUpperBarrierObservation upperBarrier;
		
		protected NoTouchRateObservationSequence0Impl(NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder builder) {
			this.lowerBarrier = ofNullable(builder.getLowerBarrier()).map(f->f.build()).orElse(null);
			this.upperBarrier = ofNullable(builder.getUpperBarrier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lowerBarrier")
		public NoTouchLowerBarrierObservation getLowerBarrier() {
			return lowerBarrier;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		public NoTouchRateObservationSequence0 build() {
			return this;
		}
		
		@Override
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder toBuilder() {
			NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder builder) {
			ofNullable(getLowerBarrier()).ifPresent(builder::setLowerBarrier);
			ofNullable(getUpperBarrier()).ifPresent(builder::setUpperBarrier);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(lowerBarrier, _that.getLowerBarrier())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBarrier != null ? lowerBarrier.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationSequence0 {" +
				"lowerBarrier=" + this.lowerBarrier + ", " +
				"upperBarrier=" + this.upperBarrier +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchRateObservationSequence0  ***********************/
	class NoTouchRateObservationSequence0BuilderImpl implements NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder {
	
		protected NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder lowerBarrier;
		protected NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder upperBarrier;
	
		public NoTouchRateObservationSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lowerBarrier")
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getLowerBarrier() {
			return lowerBarrier;
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder getOrCreateLowerBarrier() {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder result;
			if (lowerBarrier!=null) {
				result = lowerBarrier;
			}
			else {
				result = lowerBarrier = NoTouchLowerBarrierObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier() {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder result;
			if (upperBarrier!=null) {
				result = upperBarrier;
			}
			else {
				result = upperBarrier = NoTouchUpperBarrierObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBarrier")
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder setLowerBarrier(NoTouchLowerBarrierObservation lowerBarrier) {
			this.lowerBarrier = lowerBarrier==null?null:lowerBarrier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder setUpperBarrier(NoTouchUpperBarrierObservation upperBarrier) {
			this.upperBarrier = upperBarrier==null?null:upperBarrier.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchRateObservationSequence0 build() {
			return new NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Impl(this);
		}
		
		@Override
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder prune() {
			if (lowerBarrier!=null && !lowerBarrier.prune().hasData()) lowerBarrier = null;
			if (upperBarrier!=null && !upperBarrier.prune().hasData()) upperBarrier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLowerBarrier()!=null && getLowerBarrier().hasData()) return true;
			if (getUpperBarrier()!=null && getUpperBarrier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder o = (NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder) other;
			
			merger.mergeRosetta(getLowerBarrier(), o.getLowerBarrier(), this::setLowerBarrier);
			merger.mergeRosetta(getUpperBarrier(), o.getUpperBarrier(), this::setUpperBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(lowerBarrier, _that.getLowerBarrier())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBarrier != null ? lowerBarrier.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationSequence0Builder {" +
				"lowerBarrier=" + this.lowerBarrier + ", " +
				"upperBarrier=" + this.upperBarrier +
			'}';
		}
	}
}
