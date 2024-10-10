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
import fpml.confirmation.PrioritizedRateSourceModel;
import fpml.confirmation.PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder;
import fpml.confirmation.PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilderImpl;
import fpml.confirmation.PrioritizedRateSourceModel.PrioritizedRateSourceModelImpl;
import fpml.confirmation.SettlementRateOption;
import fpml.confirmation.meta.PrioritizedRateSourceModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a primary and optional secondary rate sources
 * @version ${project.version}
 */
@RosettaDataType(value="PrioritizedRateSourceModel", builder=PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilderImpl.class, version="${project.version}")
public interface PrioritizedRateSourceModel extends RosettaModelObject {

	PrioritizedRateSourceModelMeta metaData = new PrioritizedRateSourceModelMeta();

	/*********************** Getter Methods  ***********************/
	SettlementRateOption getPrimaryRateSource();
	List<? extends SettlementRateOption> getSecondaryRateSource();

	/*********************** Build Methods  ***********************/
	PrioritizedRateSourceModel build();
	
	PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder toBuilder();
	
	static PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder builder() {
		return new PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrioritizedRateSourceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrioritizedRateSourceModel> getType() {
		return PrioritizedRateSourceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.class, getSecondaryRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrioritizedRateSourceModelBuilder extends PrioritizedRateSourceModel, RosettaModelObjectBuilder {
		SettlementRateOption.SettlementRateOptionBuilder getOrCreatePrimaryRateSource();
		SettlementRateOption.SettlementRateOptionBuilder getPrimaryRateSource();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSecondaryRateSource(int _index);
		List<? extends SettlementRateOption.SettlementRateOptionBuilder> getSecondaryRateSource();
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder setPrimaryRateSource(SettlementRateOption primaryRateSource);
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource0);
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource1, int _idx);
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource2);
		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSecondaryRateSource());
		}
		

		PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder prune();
	}

	/*********************** Immutable Implementation of PrioritizedRateSourceModel  ***********************/
	class PrioritizedRateSourceModelImpl implements PrioritizedRateSourceModel {
		private final SettlementRateOption primaryRateSource;
		private final List<? extends SettlementRateOption> secondaryRateSource;
		
		protected PrioritizedRateSourceModelImpl(PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public SettlementRateOption getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public List<? extends SettlementRateOption> getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public PrioritizedRateSourceModel build() {
			return this;
		}
		
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder toBuilder() {
			PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrioritizedRateSourceModel _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrioritizedRateSourceModel {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}';
		}
	}

	/*********************** Builder Implementation of PrioritizedRateSourceModel  ***********************/
	class PrioritizedRateSourceModelBuilderImpl implements PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder {
	
		protected SettlementRateOption.SettlementRateOptionBuilder primaryRateSource;
		protected List<SettlementRateOption.SettlementRateOptionBuilder> secondaryRateSource = new ArrayList<>();
	
		public PrioritizedRateSourceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("primaryRateSource")
		public SettlementRateOption.SettlementRateOptionBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreatePrimaryRateSource() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public List<? extends SettlementRateOption.SettlementRateOptionBuilder> getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSecondaryRateSource(int _index) {
		
			if (secondaryRateSource==null) {
				this.secondaryRateSource = new ArrayList<>();
			}
			SettlementRateOption.SettlementRateOptionBuilder result;
			return getIndex(secondaryRateSource, _index, () -> {
						SettlementRateOption.SettlementRateOptionBuilder newSecondaryRateSource = SettlementRateOption.builder();
						return newSecondaryRateSource;
					});
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder setPrimaryRateSource(SettlementRateOption primaryRateSource) {
			this.primaryRateSource = primaryRateSource==null?null:primaryRateSource.toBuilder();
			return this;
		}
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource) {
			if (secondaryRateSource!=null) this.secondaryRateSource.add(secondaryRateSource.toBuilder());
			return this;
		}
		
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource, int _idx) {
			getIndex(this.secondaryRateSource, _idx, () -> secondaryRateSource.toBuilder());
			return this;
		}
		@Override 
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources != null) {
				for (SettlementRateOption toAdd : secondaryRateSources) {
					this.secondaryRateSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("secondaryRateSource")
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources == null)  {
				this.secondaryRateSource = new ArrayList<>();
			}
			else {
				this.secondaryRateSource = secondaryRateSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PrioritizedRateSourceModel build() {
			return new PrioritizedRateSourceModel.PrioritizedRateSourceModelImpl(this);
		}
		
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			secondaryRateSource = secondaryRateSource.stream().filter(b->b!=null).<SettlementRateOption.SettlementRateOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder o = (PrioritizedRateSourceModel.PrioritizedRateSourceModelBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::getOrCreateSecondaryRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrioritizedRateSourceModel _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrioritizedRateSourceModelBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}';
		}
	}
}
