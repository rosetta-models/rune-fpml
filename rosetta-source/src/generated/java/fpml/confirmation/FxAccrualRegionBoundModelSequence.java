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
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import fpml.confirmation.FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder;
import fpml.confirmation.FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilderImpl;
import fpml.confirmation.FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceImpl;
import fpml.confirmation.FxAccrualRegionLowerBound;
import fpml.confirmation.FxAccrualRegionUpperBound;
import fpml.confirmation.meta.FxAccrualRegionBoundModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualRegionBoundModelSequence", builder=FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualRegionBoundModelSequence extends RosettaModelObject {

	FxAccrualRegionBoundModelSequenceMeta metaData = new FxAccrualRegionBoundModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the lower bound of a payoff region.
	 */
	FxAccrualRegionLowerBound getLowerBound();
	/**
	 * Defines the upper bound of a payoff region.
	 */
	FxAccrualRegionUpperBound getUpperBound();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionBoundModelSequence build();
	
	FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder toBuilder();
	
	static FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder builder() {
		return new FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionBoundModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionBoundModelSequence> getType() {
		return FxAccrualRegionBoundModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.class, getLowerBound());
		processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.class, getUpperBound());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionBoundModelSequenceBuilder extends FxAccrualRegionBoundModelSequence, RosettaModelObjectBuilder {
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound();
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound();
		FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder setLowerBound(FxAccrualRegionLowerBound lowerBound);
		FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder setUpperBound(FxAccrualRegionUpperBound upperBound);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder.class, getUpperBound());
		}
		

		FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionBoundModelSequence  ***********************/
	class FxAccrualRegionBoundModelSequenceImpl implements FxAccrualRegionBoundModelSequence {
		private final FxAccrualRegionLowerBound lowerBound;
		private final FxAccrualRegionUpperBound upperBound;
		
		protected FxAccrualRegionBoundModelSequenceImpl(FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder builder) {
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public FxAccrualRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxAccrualRegionBoundModelSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder toBuilder() {
			FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder builder) {
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionBoundModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBoundModelSequence {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionBoundModelSequence  ***********************/
	class FxAccrualRegionBoundModelSequenceBuilderImpl implements FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder {
	
		protected FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder lowerBound;
		protected FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder upperBound;
	
		public FxAccrualRegionBoundModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lowerBound")
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxAccrualRegionLowerBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxAccrualRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder setLowerBound(FxAccrualRegionLowerBound lowerBound) {
			this.lowerBound = lowerBound==null?null:lowerBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder setUpperBound(FxAccrualRegionUpperBound upperBound) {
			this.upperBound = upperBound==null?null:upperBound.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionBoundModelSequence build() {
			return new FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceImpl(this);
		}
		
		@Override
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder prune() {
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder o = (FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder) other;
			
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionBoundModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBoundModelSequenceBuilder {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}
}
