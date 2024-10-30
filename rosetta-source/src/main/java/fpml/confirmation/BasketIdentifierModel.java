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
import fpml.confirmation.BasketId;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.BasketIdentifierModel.BasketIdentifierModelBuilder;
import fpml.confirmation.BasketIdentifierModel.BasketIdentifierModelBuilderImpl;
import fpml.confirmation.BasketIdentifierModel.BasketIdentifierModelImpl;
import fpml.confirmation.BasketIdentifierModelSequence;
import fpml.confirmation.meta.BasketIdentifierModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A group that specifies a name and an identifier for a given basket.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BasketIdentifierModel", builder=BasketIdentifierModel.BasketIdentifierModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BasketIdentifierModel extends RosettaModelObject {

	BasketIdentifierModelMeta metaData = new BasketIdentifierModelMeta();

	/*********************** Getter Methods  ***********************/
	BasketIdentifierModelSequence getBasketIdentifierModelSequence();
	/**
	 * A CDS basket identifier
	 */
	List<? extends BasketId> getBasketId();

	/*********************** Build Methods  ***********************/
	BasketIdentifierModel build();
	
	BasketIdentifierModel.BasketIdentifierModelBuilder toBuilder();
	
	static BasketIdentifierModel.BasketIdentifierModelBuilder builder() {
		return new BasketIdentifierModel.BasketIdentifierModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketIdentifierModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketIdentifierModel> getType() {
		return BasketIdentifierModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketIdentifierModelSequence"), processor, BasketIdentifierModelSequence.class, getBasketIdentifierModelSequence());
		processRosetta(path.newSubPath("basketId"), processor, BasketId.class, getBasketId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketIdentifierModelBuilder extends BasketIdentifierModel, RosettaModelObjectBuilder {
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder getOrCreateBasketIdentifierModelSequence();
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder getBasketIdentifierModelSequence();
		BasketId.BasketIdBuilder getOrCreateBasketId(int _index);
		List<? extends BasketId.BasketIdBuilder> getBasketId();
		BasketIdentifierModel.BasketIdentifierModelBuilder setBasketIdentifierModelSequence(BasketIdentifierModelSequence basketIdentifierModelSequence);
		BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(BasketId basketId0);
		BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(BasketId basketId1, int _idx);
		BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(List<? extends BasketId> basketId2);
		BasketIdentifierModel.BasketIdentifierModelBuilder setBasketId(List<? extends BasketId> basketId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketIdentifierModelSequence"), processor, BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder.class, getBasketIdentifierModelSequence());
			processRosetta(path.newSubPath("basketId"), processor, BasketId.BasketIdBuilder.class, getBasketId());
		}
		

		BasketIdentifierModel.BasketIdentifierModelBuilder prune();
	}

	/*********************** Immutable Implementation of BasketIdentifierModel  ***********************/
	class BasketIdentifierModelImpl implements BasketIdentifierModel {
		private final BasketIdentifierModelSequence basketIdentifierModelSequence;
		private final List<? extends BasketId> basketId;
		
		protected BasketIdentifierModelImpl(BasketIdentifierModel.BasketIdentifierModelBuilder builder) {
			this.basketIdentifierModelSequence = ofNullable(builder.getBasketIdentifierModelSequence()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModelSequence")
		public BasketIdentifierModelSequence getBasketIdentifierModelSequence() {
			return basketIdentifierModelSequence;
		}
		
		@Override
		@RosettaAttribute("basketId")
		public List<? extends BasketId> getBasketId() {
			return basketId;
		}
		
		@Override
		public BasketIdentifierModel build() {
			return this;
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder toBuilder() {
			BasketIdentifierModel.BasketIdentifierModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketIdentifierModel.BasketIdentifierModelBuilder builder) {
			ofNullable(getBasketIdentifierModelSequence()).ifPresent(builder::setBasketIdentifierModelSequence);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketIdentifierModel _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModelSequence, _that.getBasketIdentifierModelSequence())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModelSequence != null ? basketIdentifierModelSequence.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketIdentifierModel {" +
				"basketIdentifierModelSequence=" + this.basketIdentifierModelSequence + ", " +
				"basketId=" + this.basketId +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketIdentifierModel  ***********************/
	class BasketIdentifierModelBuilderImpl implements BasketIdentifierModel.BasketIdentifierModelBuilder {
	
		protected BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder basketIdentifierModelSequence;
		protected List<BasketId.BasketIdBuilder> basketId = new ArrayList<>();
	
		public BasketIdentifierModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("basketIdentifierModelSequence")
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder getBasketIdentifierModelSequence() {
			return basketIdentifierModelSequence;
		}
		
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder getOrCreateBasketIdentifierModelSequence() {
			BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder result;
			if (basketIdentifierModelSequence!=null) {
				result = basketIdentifierModelSequence;
			}
			else {
				result = basketIdentifierModelSequence = BasketIdentifierModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketId")
		public List<? extends BasketId.BasketIdBuilder> getBasketId() {
			return basketId;
		}
		
		@Override
		public BasketId.BasketIdBuilder getOrCreateBasketId(int _index) {
		
			if (basketId==null) {
				this.basketId = new ArrayList<>();
			}
			BasketId.BasketIdBuilder result;
			return getIndex(basketId, _index, () -> {
						BasketId.BasketIdBuilder newBasketId = BasketId.builder();
						return newBasketId;
					});
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModelSequence")
		public BasketIdentifierModel.BasketIdentifierModelBuilder setBasketIdentifierModelSequence(BasketIdentifierModelSequence basketIdentifierModelSequence) {
			this.basketIdentifierModelSequence = basketIdentifierModelSequence==null?null:basketIdentifierModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("basketId")
		public BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(BasketId basketId) {
			if (basketId!=null) this.basketId.add(basketId.toBuilder());
			return this;
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(BasketId basketId, int _idx) {
			getIndex(this.basketId, _idx, () -> basketId.toBuilder());
			return this;
		}
		@Override 
		public BasketIdentifierModel.BasketIdentifierModelBuilder addBasketId(List<? extends BasketId> basketIds) {
			if (basketIds != null) {
				for (BasketId toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BasketIdentifierModel.BasketIdentifierModelBuilder setBasketId(List<? extends BasketId> basketIds) {
			if (basketIds == null)  {
				this.basketId = new ArrayList<>();
			}
			else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public BasketIdentifierModel build() {
			return new BasketIdentifierModel.BasketIdentifierModelImpl(this);
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder prune() {
			if (basketIdentifierModelSequence!=null && !basketIdentifierModelSequence.prune().hasData()) basketIdentifierModelSequence = null;
			basketId = basketId.stream().filter(b->b!=null).<BasketId.BasketIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketIdentifierModelSequence()!=null && getBasketIdentifierModelSequence().hasData()) return true;
			if (getBasketId()!=null && getBasketId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketIdentifierModel.BasketIdentifierModelBuilder o = (BasketIdentifierModel.BasketIdentifierModelBuilder) other;
			
			merger.mergeRosetta(getBasketIdentifierModelSequence(), o.getBasketIdentifierModelSequence(), this::setBasketIdentifierModelSequence);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketIdentifierModel _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModelSequence, _that.getBasketIdentifierModelSequence())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModelSequence != null ? basketIdentifierModelSequence.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketIdentifierModelBuilder {" +
				"basketIdentifierModelSequence=" + this.basketIdentifierModelSequence + ", " +
				"basketId=" + this.basketId +
			'}';
		}
	}
}
