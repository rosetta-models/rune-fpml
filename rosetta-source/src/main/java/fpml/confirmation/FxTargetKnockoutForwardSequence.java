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
import fpml.confirmation.FxPivot;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder;
import fpml.confirmation.FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilderImpl;
import fpml.confirmation.FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceImpl;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.meta.FxTargetKnockoutForwardSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetKnockoutForwardSequence", builder=FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilderImpl.class, version="${project.version}")
public interface FxTargetKnockoutForwardSequence extends RosettaModelObject {

	FxTargetKnockoutForwardSequenceMeta metaData = new FxTargetKnockoutForwardSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The boundary where the contract flips from being long and short is the pivot point. So the pivot indicates the level in which there is a change in direction of the currencies exchanged by the parties.
	 */
	FxPivot getPivot();
	/**
	 * A region in which constant payoff applies i.e. the payoff is defined as a contant currency amount or fixing adjustment, unrelated to the fixing. In absence of the &quot;payoff&quot; element, zero payoff is assumed (note: zero payoff does not necessarily imply that no settlement occurs).
	 */
	List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion();
	/**
	 * A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 */
	FxTargetLinearPayoffRegion getLinearPayoffRegion();

	/*********************** Build Methods  ***********************/
	FxTargetKnockoutForwardSequence build();
	
	FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder toBuilder();
	
	static FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder builder() {
		return new FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetKnockoutForwardSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetKnockoutForwardSequence> getType() {
		return FxTargetKnockoutForwardSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pivot"), processor, FxPivot.class, getPivot());
		processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.class, getConstantPayoffRegion());
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.class, getLinearPayoffRegion());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetKnockoutForwardSequenceBuilder extends FxTargetKnockoutForwardSequence, RosettaModelObjectBuilder {
		FxPivot.FxPivotBuilder getOrCreatePivot();
		FxPivot.FxPivotBuilder getPivot();
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int _index);
		List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion();
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setPivot(FxPivot pivot);
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion0);
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion1, int _idx);
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion2);
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion3);
		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pivot"), processor, FxPivot.FxPivotBuilder.class, getPivot());
			processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder.class, getConstantPayoffRegion());
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
		}
		

		FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetKnockoutForwardSequence  ***********************/
	class FxTargetKnockoutForwardSequenceImpl implements FxTargetKnockoutForwardSequence {
		private final FxPivot pivot;
		private final List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion;
		private final FxTargetLinearPayoffRegion linearPayoffRegion;
		
		protected FxTargetKnockoutForwardSequenceImpl(FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder builder) {
			this.pivot = ofNullable(builder.getPivot()).map(f->f.build()).orElse(null);
			this.constantPayoffRegion = ofNullable(builder.getConstantPayoffRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pivot")
		public FxPivot getPivot() {
			return pivot;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetKnockoutForwardSequence build() {
			return this;
		}
		
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder toBuilder() {
			FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder builder) {
			ofNullable(getPivot()).ifPresent(builder::setPivot);
			ofNullable(getConstantPayoffRegion()).ifPresent(builder::setConstantPayoffRegion);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetKnockoutForwardSequence _that = getType().cast(o);
		
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardSequence {" +
				"pivot=" + this.pivot + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetKnockoutForwardSequence  ***********************/
	class FxTargetKnockoutForwardSequenceBuilderImpl implements FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder {
	
		protected FxPivot.FxPivotBuilder pivot;
		protected List<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> constantPayoffRegion = new ArrayList<>();
		protected FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder linearPayoffRegion;
	
		public FxTargetKnockoutForwardSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("pivot")
		public FxPivot.FxPivotBuilder getPivot() {
			return pivot;
		}
		
		@Override
		public FxPivot.FxPivotBuilder getOrCreatePivot() {
			FxPivot.FxPivotBuilder result;
			if (pivot!=null) {
				result = pivot;
			}
			else {
				result = pivot = FxPivot.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int _index) {
		
			if (constantPayoffRegion==null) {
				this.constantPayoffRegion = new ArrayList<>();
			}
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder result;
			return getIndex(constantPayoffRegion, _index, () -> {
						FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder newConstantPayoffRegion = FxTargetConstantPayoffRegion.builder();
						return newConstantPayoffRegion;
					});
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion() {
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder result;
			if (linearPayoffRegion!=null) {
				result = linearPayoffRegion;
			}
			else {
				result = linearPayoffRegion = FxTargetLinearPayoffRegion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pivot")
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setPivot(FxPivot pivot) {
			this.pivot = pivot==null?null:pivot.toBuilder();
			return this;
		}
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion) {
			if (constantPayoffRegion!=null) this.constantPayoffRegion.add(constantPayoffRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion, int _idx) {
			getIndex(this.constantPayoffRegion, _idx, () -> constantPayoffRegion.toBuilder());
			return this;
		}
		@Override 
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions != null) {
				for (FxTargetConstantPayoffRegion toAdd : constantPayoffRegions) {
					this.constantPayoffRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("constantPayoffRegion")
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions == null)  {
				this.constantPayoffRegion = new ArrayList<>();
			}
			else {
				this.constantPayoffRegion = constantPayoffRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion) {
			this.linearPayoffRegion = linearPayoffRegion==null?null:linearPayoffRegion.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetKnockoutForwardSequence build() {
			return new FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceImpl(this);
		}
		
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder prune() {
			if (pivot!=null && !pivot.prune().hasData()) pivot = null;
			constantPayoffRegion = constantPayoffRegion.stream().filter(b->b!=null).<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (linearPayoffRegion!=null && !linearPayoffRegion.prune().hasData()) linearPayoffRegion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPivot()!=null && getPivot().hasData()) return true;
			if (getConstantPayoffRegion()!=null && getConstantPayoffRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder o = (FxTargetKnockoutForwardSequence.FxTargetKnockoutForwardSequenceBuilder) other;
			
			merger.mergeRosetta(getPivot(), o.getPivot(), this::setPivot);
			merger.mergeRosetta(getConstantPayoffRegion(), o.getConstantPayoffRegion(), this::getOrCreateConstantPayoffRegion);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::setLinearPayoffRegion);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetKnockoutForwardSequence _that = getType().cast(o);
		
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardSequenceBuilder {" +
				"pivot=" + this.pivot + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion +
			'}';
		}
	}
}
