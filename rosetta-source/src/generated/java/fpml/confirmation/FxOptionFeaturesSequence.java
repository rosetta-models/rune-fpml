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
import fpml.confirmation.FxAsianFeature;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.FxOptionFeaturesSequence;
import fpml.confirmation.FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder;
import fpml.confirmation.FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilderImpl;
import fpml.confirmation.FxOptionFeaturesSequence.FxOptionFeaturesSequenceImpl;
import fpml.confirmation.meta.FxOptionFeaturesSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxOptionFeaturesSequence", builder=FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilderImpl.class, version="${project.version}")
public interface FxOptionFeaturesSequence extends RosettaModelObject {

	FxOptionFeaturesSequenceMeta metaData = new FxOptionFeaturesSequenceMeta();

	/*********************** Getter Methods  ***********************/
	FxAsianFeature getAsian();
	List<? extends FxBarrierFeature> getBarrier();

	/*********************** Build Methods  ***********************/
	FxOptionFeaturesSequence build();
	
	FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder toBuilder();
	
	static FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder builder() {
		return new FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionFeaturesSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOptionFeaturesSequence> getType() {
		return FxOptionFeaturesSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("asian"), processor, FxAsianFeature.class, getAsian());
		processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionFeaturesSequenceBuilder extends FxOptionFeaturesSequence, RosettaModelObjectBuilder {
		FxAsianFeature.FxAsianFeatureBuilder getOrCreateAsian();
		FxAsianFeature.FxAsianFeatureBuilder getAsian();
		FxBarrierFeature.FxBarrierFeatureBuilder getOrCreateBarrier(int _index);
		List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier();
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder setAsian(FxAsianFeature asian);
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(FxBarrierFeature barrier0);
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(FxBarrierFeature barrier1, int _idx);
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(List<? extends FxBarrierFeature> barrier2);
		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder setBarrier(List<? extends FxBarrierFeature> barrier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("asian"), processor, FxAsianFeature.FxAsianFeatureBuilder.class, getAsian());
			processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.FxBarrierFeatureBuilder.class, getBarrier());
		}
		

		FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionFeaturesSequence  ***********************/
	class FxOptionFeaturesSequenceImpl implements FxOptionFeaturesSequence {
		private final FxAsianFeature asian;
		private final List<? extends FxBarrierFeature> barrier;
		
		protected FxOptionFeaturesSequenceImpl(FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder builder) {
			this.asian = ofNullable(builder.getAsian()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("asian")
		public FxAsianFeature getAsian() {
			return asian;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxBarrierFeature> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxOptionFeaturesSequence build() {
			return this;
		}
		
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder toBuilder() {
			FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder builder) {
			ofNullable(getAsian()).ifPresent(builder::setAsian);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeaturesSequence _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeaturesSequence {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}

	/*********************** Builder Implementation of FxOptionFeaturesSequence  ***********************/
	class FxOptionFeaturesSequenceBuilderImpl implements FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder {
	
		protected FxAsianFeature.FxAsianFeatureBuilder asian;
		protected List<FxBarrierFeature.FxBarrierFeatureBuilder> barrier = new ArrayList<>();
	
		public FxOptionFeaturesSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("asian")
		public FxAsianFeature.FxAsianFeatureBuilder getAsian() {
			return asian;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder getOrCreateAsian() {
			FxAsianFeature.FxAsianFeatureBuilder result;
			if (asian!=null) {
				result = asian;
			}
			else {
				result = asian = FxAsianFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier() {
			return barrier;
		}
		
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
		@RosettaAttribute("asian")
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder setAsian(FxAsianFeature asian) {
			this.asian = asian==null?null:asian.toBuilder();
			return this;
		}
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(FxBarrierFeature barrier) {
			if (barrier!=null) this.barrier.add(barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(FxBarrierFeature barrier, int _idx) {
			getIndex(this.barrier, _idx, () -> barrier.toBuilder());
			return this;
		}
		@Override 
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder addBarrier(List<? extends FxBarrierFeature> barriers) {
			if (barriers != null) {
				for (FxBarrierFeature toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("barrier")
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder setBarrier(List<? extends FxBarrierFeature> barriers) {
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
		public FxOptionFeaturesSequence build() {
			return new FxOptionFeaturesSequence.FxOptionFeaturesSequenceImpl(this);
		}
		
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder prune() {
			if (asian!=null && !asian.prune().hasData()) asian = null;
			barrier = barrier.stream().filter(b->b!=null).<FxBarrierFeature.FxBarrierFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsian()!=null && getAsian().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder o = (FxOptionFeaturesSequence.FxOptionFeaturesSequenceBuilder) other;
			
			merger.mergeRosetta(getAsian(), o.getAsian(), this::setAsian);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeaturesSequence _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeaturesSequenceBuilder {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}
}
