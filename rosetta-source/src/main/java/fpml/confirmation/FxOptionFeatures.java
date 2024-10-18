package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionFeatures.FxOptionFeaturesBuilder;
import fpml.confirmation.FxOptionFeatures.FxOptionFeaturesBuilderImpl;
import fpml.confirmation.FxOptionFeatures.FxOptionFeaturesImpl;
import fpml.confirmation.FxOptionFeaturesSequence;
import fpml.confirmation.meta.FxOptionFeaturesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing the features that may be present in an FX option.
 * @version ${project.version}
 */
@RosettaDataType(value="FxOptionFeatures", builder=FxOptionFeatures.FxOptionFeaturesBuilderImpl.class, version="${project.version}")
public interface FxOptionFeatures extends RosettaModelObject {

	FxOptionFeaturesMeta metaData = new FxOptionFeaturesMeta();

	/*********************** Getter Methods  ***********************/
	FxOptionFeaturesSequence getFxOptionFeaturesSequence();
	List<? extends FxBarrierFeature> getBarrier();

	/*********************** Build Methods  ***********************/
	FxOptionFeatures build();
	
	FxOptionFeatures.FxOptionFeaturesBuilder toBuilder();
	
	static FxOptionFeatures.FxOptionFeaturesBuilder builder() {
		return new FxOptionFeatures.FxOptionFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionFeatures> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOptionFeatures> getType() {
		return FxOptionFeatures.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxOptionFeaturesSequence"), processor, FxOptionFeaturesSequence.class, getFxOptionFeaturesSequence());
		processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionFeaturesBuilder extends FxOptionFeatures, RosettaModelObjectBuilder {
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder getOrCreateFxOptionFeaturesSequence();
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder getFxOptionFeaturesSequence();
		FxBarrierFeature.FxBarrierFeatureBuilder getOrCreateBarrier(int _index);
		List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier();
		FxOptionFeatures.FxOptionFeaturesBuilder setFxOptionFeaturesSequence(FxOptionFeaturesSequence fxOptionFeaturesSequence);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier0);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier1, int _idx);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(List<? extends FxBarrierFeature> barrier2);
		FxOptionFeatures.FxOptionFeaturesBuilder setBarrier(List<? extends FxBarrierFeature> barrier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxOptionFeaturesSequence"), processor, FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder.class, getFxOptionFeaturesSequence());
			processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.FxBarrierFeatureBuilder.class, getBarrier());
		}
		

		FxOptionFeatures.FxOptionFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionFeatures  ***********************/
	class FxOptionFeaturesImpl implements FxOptionFeatures {
		private final FxOptionFeaturesSequence fxOptionFeaturesSequence;
		private final List<? extends FxBarrierFeature> barrier;
		
		protected FxOptionFeaturesImpl(FxOptionFeatures.FxOptionFeaturesBuilder builder) {
			this.fxOptionFeaturesSequence = ofNullable(builder.getFxOptionFeaturesSequence()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxOptionFeaturesSequence")
		public FxOptionFeaturesSequence getFxOptionFeaturesSequence() {
			return fxOptionFeaturesSequence;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxBarrierFeature> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxOptionFeatures build() {
			return this;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder toBuilder() {
			FxOptionFeatures.FxOptionFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionFeatures.FxOptionFeaturesBuilder builder) {
			ofNullable(getFxOptionFeaturesSequence()).ifPresent(builder::setFxOptionFeaturesSequence);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(fxOptionFeaturesSequence, _that.getFxOptionFeaturesSequence())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxOptionFeaturesSequence != null ? fxOptionFeaturesSequence.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeatures {" +
				"fxOptionFeaturesSequence=" + this.fxOptionFeaturesSequence + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}

	/*********************** Builder Implementation of FxOptionFeatures  ***********************/
	class FxOptionFeaturesBuilderImpl implements FxOptionFeatures.FxOptionFeaturesBuilder {
	
		protected FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder fxOptionFeaturesSequence;
		protected List<FxBarrierFeature.FxBarrierFeatureBuilder> barrier = new ArrayList<>();
	
		public FxOptionFeaturesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxOptionFeaturesSequence")
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder getFxOptionFeaturesSequence() {
			return fxOptionFeaturesSequence;
		}
		
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder getOrCreateFxOptionFeaturesSequence() {
			FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder result;
			if (fxOptionFeaturesSequence!=null) {
				result = fxOptionFeaturesSequence;
			}
			else {
				result = fxOptionFeaturesSequence = FxOptionFeaturesSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder getOrCreateBarrier(int _index) {
		
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			FxBarrierFeature.FxBarrierFeatureBuilder result;
			return getIndex(barrier, _index, () -> {
						FxBarrierFeature.FxBarrierFeatureBuilder newBarrier = FxBarrierFeature.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("fxOptionFeaturesSequence")
		public FxOptionFeatures.FxOptionFeaturesBuilder setFxOptionFeaturesSequence(FxOptionFeaturesSequence fxOptionFeaturesSequence) {
			this.fxOptionFeaturesSequence = fxOptionFeaturesSequence==null?null:fxOptionFeaturesSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(List<? extends FxBarrierFeature> barriers) {
			if (barriers != null) {
				for (FxBarrierFeature toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxOptionFeatures.FxOptionFeaturesBuilder setBarrier(List<? extends FxBarrierFeature> barriers) {
			if (barriers == null)  {
				this.barrier = new ArrayList<>();
			}
			else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxOptionFeatures build() {
			return new FxOptionFeatures.FxOptionFeaturesImpl(this);
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder prune() {
			if (fxOptionFeaturesSequence!=null && !fxOptionFeaturesSequence.prune().hasData()) fxOptionFeaturesSequence = null;
			barrier = barrier.stream().filter(b->b!=null).<FxBarrierFeature.FxBarrierFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxOptionFeaturesSequence()!=null && getFxOptionFeaturesSequence().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxOptionFeatures.FxOptionFeaturesBuilder o = (FxOptionFeatures.FxOptionFeaturesBuilder) other;
			
			merger.mergeRosetta(getFxOptionFeaturesSequence(), o.getFxOptionFeaturesSequence(), this::setFxOptionFeaturesSequence);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(fxOptionFeaturesSequence, _that.getFxOptionFeaturesSequence())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxOptionFeaturesSequence != null ? fxOptionFeaturesSequence.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeaturesBuilder {" +
				"fxOptionFeaturesSequence=" + this.fxOptionFeaturesSequence + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}
}
