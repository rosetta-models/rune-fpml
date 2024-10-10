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
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeIdentifierModel.ExchangeIdentifierModelBuilder;
import fpml.confirmation.ExchangeIdentifierModel.ExchangeIdentifierModelBuilderImpl;
import fpml.confirmation.ExchangeIdentifierModel.ExchangeIdentifierModelImpl;
import fpml.confirmation.meta.ExchangeIdentifierModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeIdentifierModel", builder=ExchangeIdentifierModel.ExchangeIdentifierModelBuilderImpl.class, version="${project.version}")
public interface ExchangeIdentifierModel extends RosettaModelObject {

	ExchangeIdentifierModelMeta metaData = new ExchangeIdentifierModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A short form unique identifier for a related exchange. If the element is not present then the exchange shall be the primary exchange on which listed futures and options on the underlying are listed. The term &quot;Exchange&quot; is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	List<? extends ExchangeId> getRelatedExchangeId();
	/**
	 * A short form unique identifier for an exchange on which the reference option contract is listed. This is to address the case where the reference exchange for the future is different than the one for the option. The options Exchange is referenced on share options when Merger Elections are selected as Options Exchange Adjustment.
	 */
	List<? extends ExchangeId> getOptionsExchangeId();
	/**
	 * A short form unique identifier for a specified exchange. If the element is not present then the exchange shall be default terms as defined in the MCA; unless otherwise specified in the Transaction Supplement.
	 */
	List<? extends ExchangeId> getSpecifiedExchangeId();

	/*********************** Build Methods  ***********************/
	ExchangeIdentifierModel build();
	
	ExchangeIdentifierModel.ExchangeIdentifierModelBuilder toBuilder();
	
	static ExchangeIdentifierModel.ExchangeIdentifierModelBuilder builder() {
		return new ExchangeIdentifierModel.ExchangeIdentifierModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeIdentifierModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeIdentifierModel> getType() {
		return ExchangeIdentifierModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.class, getRelatedExchangeId());
		processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.class, getOptionsExchangeId());
		processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.class, getSpecifiedExchangeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeIdentifierModelBuilder extends ExchangeIdentifierModel, RosettaModelObjectBuilder {
		ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int _index);
		List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int _index);
		List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId();
		ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int _index);
		List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId();
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(ExchangeId relatedExchangeId0);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(ExchangeId relatedExchangeId1, int _idx);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId2);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId3);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(ExchangeId optionsExchangeId0);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(ExchangeId optionsExchangeId1, int _idx);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId2);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId3);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId0);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId1, int _idx);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId2);
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getRelatedExchangeId());
			processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getOptionsExchangeId());
			processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getSpecifiedExchangeId());
		}
		

		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeIdentifierModel  ***********************/
	class ExchangeIdentifierModelImpl implements ExchangeIdentifierModel {
		private final List<? extends ExchangeId> relatedExchangeId;
		private final List<? extends ExchangeId> optionsExchangeId;
		private final List<? extends ExchangeId> specifiedExchangeId;
		
		protected ExchangeIdentifierModelImpl(ExchangeIdentifierModel.ExchangeIdentifierModelBuilder builder) {
			this.relatedExchangeId = ofNullable(builder.getRelatedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionsExchangeId = ofNullable(builder.getOptionsExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specifiedExchangeId = ofNullable(builder.getSpecifiedExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedExchangeId")
		public List<? extends ExchangeId> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		public List<? extends ExchangeId> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		public List<? extends ExchangeId> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		@Override
		public ExchangeIdentifierModel build() {
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder toBuilder() {
			ExchangeIdentifierModel.ExchangeIdentifierModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeIdentifierModel.ExchangeIdentifierModelBuilder builder) {
			ofNullable(getRelatedExchangeId()).ifPresent(builder::setRelatedExchangeId);
			ofNullable(getOptionsExchangeId()).ifPresent(builder::setOptionsExchangeId);
			ofNullable(getSpecifiedExchangeId()).ifPresent(builder::setSpecifiedExchangeId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeIdentifierModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeIdentifierModel {" +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeIdentifierModel  ***********************/
	class ExchangeIdentifierModelBuilderImpl implements ExchangeIdentifierModel.ExchangeIdentifierModelBuilder {
	
		protected List<ExchangeId.ExchangeIdBuilder> relatedExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> optionsExchangeId = new ArrayList<>();
		protected List<ExchangeId.ExchangeIdBuilder> specifiedExchangeId = new ArrayList<>();
	
		public ExchangeIdentifierModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relatedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getRelatedExchangeId() {
			return relatedExchangeId;
		}
		
		public ExchangeId.ExchangeIdBuilder getOrCreateRelatedExchangeId(int _index) {
		
			if (relatedExchangeId==null) {
				this.relatedExchangeId = new ArrayList<>();
			}
			ExchangeId.ExchangeIdBuilder result;
			return getIndex(relatedExchangeId, _index, () -> {
						ExchangeId.ExchangeIdBuilder newRelatedExchangeId = ExchangeId.builder();
						return newRelatedExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("optionsExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getOptionsExchangeId() {
			return optionsExchangeId;
		}
		
		public ExchangeId.ExchangeIdBuilder getOrCreateOptionsExchangeId(int _index) {
		
			if (optionsExchangeId==null) {
				this.optionsExchangeId = new ArrayList<>();
			}
			ExchangeId.ExchangeIdBuilder result;
			return getIndex(optionsExchangeId, _index, () -> {
						ExchangeId.ExchangeIdBuilder newOptionsExchangeId = ExchangeId.builder();
						return newOptionsExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("specifiedExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getSpecifiedExchangeId() {
			return specifiedExchangeId;
		}
		
		public ExchangeId.ExchangeIdBuilder getOrCreateSpecifiedExchangeId(int _index) {
		
			if (specifiedExchangeId==null) {
				this.specifiedExchangeId = new ArrayList<>();
			}
			ExchangeId.ExchangeIdBuilder result;
			return getIndex(specifiedExchangeId, _index, () -> {
						ExchangeId.ExchangeIdBuilder newSpecifiedExchangeId = ExchangeId.builder();
						return newSpecifiedExchangeId;
					});
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(ExchangeId relatedExchangeId) {
			if (relatedExchangeId!=null) this.relatedExchangeId.add(relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int _idx) {
			getIndex(this.relatedExchangeId, _idx, () -> relatedExchangeId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds != null) {
				for (ExchangeId toAdd : relatedExchangeIds) {
					this.relatedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("relatedExchangeId")
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds == null)  {
				this.relatedExchangeId = new ArrayList<>();
			}
			else {
				this.relatedExchangeId = relatedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(ExchangeId optionsExchangeId) {
			if (optionsExchangeId!=null) this.optionsExchangeId.add(optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int _idx) {
			getIndex(this.optionsExchangeId, _idx, () -> optionsExchangeId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds != null) {
				for (ExchangeId toAdd : optionsExchangeIds) {
					this.optionsExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("optionsExchangeId")
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds == null)  {
				this.optionsExchangeId = new ArrayList<>();
			}
			else {
				this.optionsExchangeId = optionsExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId) {
			if (specifiedExchangeId!=null) this.specifiedExchangeId.add(specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int _idx) {
			getIndex(this.specifiedExchangeId, _idx, () -> specifiedExchangeId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds != null) {
				for (ExchangeId toAdd : specifiedExchangeIds) {
					this.specifiedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("specifiedExchangeId")
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null)  {
				this.specifiedExchangeId = new ArrayList<>();
			}
			else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ExchangeIdentifierModel build() {
			return new ExchangeIdentifierModel.ExchangeIdentifierModelImpl(this);
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder prune() {
			relatedExchangeId = relatedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			optionsExchangeId = optionsExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			specifiedExchangeId = specifiedExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelatedExchangeId()!=null && getRelatedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionsExchangeId()!=null && getOptionsExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecifiedExchangeId()!=null && getSpecifiedExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeIdentifierModel.ExchangeIdentifierModelBuilder o = (ExchangeIdentifierModel.ExchangeIdentifierModelBuilder) other;
			
			merger.mergeRosetta(getRelatedExchangeId(), o.getRelatedExchangeId(), this::getOrCreateRelatedExchangeId);
			merger.mergeRosetta(getOptionsExchangeId(), o.getOptionsExchangeId(), this::getOrCreateOptionsExchangeId);
			merger.mergeRosetta(getSpecifiedExchangeId(), o.getSpecifiedExchangeId(), this::getOrCreateSpecifiedExchangeId);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeIdentifierModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedExchangeId, _that.getRelatedExchangeId())) return false;
			if (!ListEquals.listEquals(optionsExchangeId, _that.getOptionsExchangeId())) return false;
			if (!ListEquals.listEquals(specifiedExchangeId, _that.getSpecifiedExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedExchangeId != null ? relatedExchangeId.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeId != null ? optionsExchangeId.hashCode() : 0);
			_result = 31 * _result + (specifiedExchangeId != null ? specifiedExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeIdentifierModelBuilder {" +
				"relatedExchangeId=" + this.relatedExchangeId + ", " +
				"optionsExchangeId=" + this.optionsExchangeId + ", " +
				"specifiedExchangeId=" + this.specifiedExchangeId +
			'}';
		}
	}
}
