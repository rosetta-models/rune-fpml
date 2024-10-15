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
import fpml.confirmation.FxKnockoutCount;
import fpml.confirmation.FxKnockoutLevel;
import fpml.confirmation.FxTarget;
import fpml.confirmation.FxTarget.FxTargetBuilder;
import fpml.confirmation.FxTarget.FxTargetBuilderImpl;
import fpml.confirmation.FxTarget.FxTargetImpl;
import fpml.confirmation.FxTargetAccumulationRegion;
import fpml.confirmation.meta.FxTargetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTarget", builder=FxTarget.FxTargetBuilderImpl.class, version="${project.version}")
public interface FxTarget extends RosettaModelObject {

	FxTargetMeta metaData = new FxTargetMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends FxTargetAccumulationRegion> getAccumulationRegion();
	FxKnockoutLevel getKnockoutLevel();
	FxKnockoutCount getKnockoutCount();
	String getId();

	/*********************** Build Methods  ***********************/
	FxTarget build();
	
	FxTarget.FxTargetBuilder toBuilder();
	
	static FxTarget.FxTargetBuilder builder() {
		return new FxTarget.FxTargetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTarget> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTarget> getType() {
		return FxTarget.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accumulationRegion"), processor, FxTargetAccumulationRegion.class, getAccumulationRegion());
		processRosetta(path.newSubPath("knockoutLevel"), processor, FxKnockoutLevel.class, getKnockoutLevel());
		processRosetta(path.newSubPath("knockoutCount"), processor, FxKnockoutCount.class, getKnockoutCount());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetBuilder extends FxTarget, RosettaModelObjectBuilder {
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder getOrCreateAccumulationRegion(int _index);
		List<? extends FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> getAccumulationRegion();
		FxKnockoutLevel.FxKnockoutLevelBuilder getOrCreateKnockoutLevel();
		FxKnockoutLevel.FxKnockoutLevelBuilder getKnockoutLevel();
		FxKnockoutCount.FxKnockoutCountBuilder getOrCreateKnockoutCount();
		FxKnockoutCount.FxKnockoutCountBuilder getKnockoutCount();
		FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion0);
		FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion1, int _idx);
		FxTarget.FxTargetBuilder addAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegion2);
		FxTarget.FxTargetBuilder setAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegion3);
		FxTarget.FxTargetBuilder setKnockoutLevel(FxKnockoutLevel knockoutLevel);
		FxTarget.FxTargetBuilder setKnockoutCount(FxKnockoutCount knockoutCount);
		FxTarget.FxTargetBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accumulationRegion"), processor, FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder.class, getAccumulationRegion());
			processRosetta(path.newSubPath("knockoutLevel"), processor, FxKnockoutLevel.FxKnockoutLevelBuilder.class, getKnockoutLevel());
			processRosetta(path.newSubPath("knockoutCount"), processor, FxKnockoutCount.FxKnockoutCountBuilder.class, getKnockoutCount());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxTarget.FxTargetBuilder prune();
	}

	/*********************** Immutable Implementation of FxTarget  ***********************/
	class FxTargetImpl implements FxTarget {
		private final List<? extends FxTargetAccumulationRegion> accumulationRegion;
		private final FxKnockoutLevel knockoutLevel;
		private final FxKnockoutCount knockoutCount;
		private final String id;
		
		protected FxTargetImpl(FxTarget.FxTargetBuilder builder) {
			this.accumulationRegion = ofNullable(builder.getAccumulationRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.knockoutLevel = ofNullable(builder.getKnockoutLevel()).map(f->f.build()).orElse(null);
			this.knockoutCount = ofNullable(builder.getKnockoutCount()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("accumulationRegion")
		public List<? extends FxTargetAccumulationRegion> getAccumulationRegion() {
			return accumulationRegion;
		}
		
		@Override
		@RosettaAttribute("knockoutLevel")
		public FxKnockoutLevel getKnockoutLevel() {
			return knockoutLevel;
		}
		
		@Override
		@RosettaAttribute("knockoutCount")
		public FxKnockoutCount getKnockoutCount() {
			return knockoutCount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxTarget build() {
			return this;
		}
		
		@Override
		public FxTarget.FxTargetBuilder toBuilder() {
			FxTarget.FxTargetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTarget.FxTargetBuilder builder) {
			ofNullable(getAccumulationRegion()).ifPresent(builder::setAccumulationRegion);
			ofNullable(getKnockoutLevel()).ifPresent(builder::setKnockoutLevel);
			ofNullable(getKnockoutCount()).ifPresent(builder::setKnockoutCount);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTarget _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accumulationRegion, _that.getAccumulationRegion())) return false;
			if (!Objects.equals(knockoutLevel, _that.getKnockoutLevel())) return false;
			if (!Objects.equals(knockoutCount, _that.getKnockoutCount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accumulationRegion != null ? accumulationRegion.hashCode() : 0);
			_result = 31 * _result + (knockoutLevel != null ? knockoutLevel.hashCode() : 0);
			_result = 31 * _result + (knockoutCount != null ? knockoutCount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTarget {" +
				"accumulationRegion=" + this.accumulationRegion + ", " +
				"knockoutLevel=" + this.knockoutLevel + ", " +
				"knockoutCount=" + this.knockoutCount + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTarget  ***********************/
	class FxTargetBuilderImpl implements FxTarget.FxTargetBuilder {
	
		protected List<FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> accumulationRegion = new ArrayList<>();
		protected FxKnockoutLevel.FxKnockoutLevelBuilder knockoutLevel;
		protected FxKnockoutCount.FxKnockoutCountBuilder knockoutCount;
		protected String id;
	
		public FxTargetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accumulationRegion")
		public List<? extends FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> getAccumulationRegion() {
			return accumulationRegion;
		}
		
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder getOrCreateAccumulationRegion(int _index) {
		
			if (accumulationRegion==null) {
				this.accumulationRegion = new ArrayList<>();
			}
			FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder result;
			return getIndex(accumulationRegion, _index, () -> {
						FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder newAccumulationRegion = FxTargetAccumulationRegion.builder();
						return newAccumulationRegion;
					});
		}
		
		@Override
		@RosettaAttribute("knockoutLevel")
		public FxKnockoutLevel.FxKnockoutLevelBuilder getKnockoutLevel() {
			return knockoutLevel;
		}
		
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder getOrCreateKnockoutLevel() {
			FxKnockoutLevel.FxKnockoutLevelBuilder result;
			if (knockoutLevel!=null) {
				result = knockoutLevel;
			}
			else {
				result = knockoutLevel = FxKnockoutLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knockoutCount")
		public FxKnockoutCount.FxKnockoutCountBuilder getKnockoutCount() {
			return knockoutCount;
		}
		
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder getOrCreateKnockoutCount() {
			FxKnockoutCount.FxKnockoutCountBuilder result;
			if (knockoutCount!=null) {
				result = knockoutCount;
			}
			else {
				result = knockoutCount = FxKnockoutCount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion) {
			if (accumulationRegion!=null) this.accumulationRegion.add(accumulationRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion, int _idx) {
			getIndex(this.accumulationRegion, _idx, () -> accumulationRegion.toBuilder());
			return this;
		}
		@Override 
		public FxTarget.FxTargetBuilder addAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegions) {
			if (accumulationRegions != null) {
				for (FxTargetAccumulationRegion toAdd : accumulationRegions) {
					this.accumulationRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accumulationRegion")
		public FxTarget.FxTargetBuilder setAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegions) {
			if (accumulationRegions == null)  {
				this.accumulationRegion = new ArrayList<>();
			}
			else {
				this.accumulationRegion = accumulationRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("knockoutLevel")
		public FxTarget.FxTargetBuilder setKnockoutLevel(FxKnockoutLevel knockoutLevel) {
			this.knockoutLevel = knockoutLevel==null?null:knockoutLevel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("knockoutCount")
		public FxTarget.FxTargetBuilder setKnockoutCount(FxKnockoutCount knockoutCount) {
			this.knockoutCount = knockoutCount==null?null:knockoutCount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxTarget.FxTargetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxTarget build() {
			return new FxTarget.FxTargetImpl(this);
		}
		
		@Override
		public FxTarget.FxTargetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTarget.FxTargetBuilder prune() {
			accumulationRegion = accumulationRegion.stream().filter(b->b!=null).<FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (knockoutLevel!=null && !knockoutLevel.prune().hasData()) knockoutLevel = null;
			if (knockoutCount!=null && !knockoutCount.prune().hasData()) knockoutCount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccumulationRegion()!=null && getAccumulationRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getKnockoutLevel()!=null && getKnockoutLevel().hasData()) return true;
			if (getKnockoutCount()!=null && getKnockoutCount().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTarget.FxTargetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTarget.FxTargetBuilder o = (FxTarget.FxTargetBuilder) other;
			
			merger.mergeRosetta(getAccumulationRegion(), o.getAccumulationRegion(), this::getOrCreateAccumulationRegion);
			merger.mergeRosetta(getKnockoutLevel(), o.getKnockoutLevel(), this::setKnockoutLevel);
			merger.mergeRosetta(getKnockoutCount(), o.getKnockoutCount(), this::setKnockoutCount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTarget _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accumulationRegion, _that.getAccumulationRegion())) return false;
			if (!Objects.equals(knockoutLevel, _that.getKnockoutLevel())) return false;
			if (!Objects.equals(knockoutCount, _that.getKnockoutCount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accumulationRegion != null ? accumulationRegion.hashCode() : 0);
			_result = 31 * _result + (knockoutLevel != null ? knockoutLevel.hashCode() : 0);
			_result = 31 * _result + (knockoutCount != null ? knockoutCount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBuilder {" +
				"accumulationRegion=" + this.accumulationRegion + ", " +
				"knockoutLevel=" + this.knockoutLevel + ", " +
				"knockoutCount=" + this.knockoutCount + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
