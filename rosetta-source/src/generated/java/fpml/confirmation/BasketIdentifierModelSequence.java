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
import fpml.confirmation.BasketIdentifierModelSequence;
import fpml.confirmation.BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder;
import fpml.confirmation.BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilderImpl;
import fpml.confirmation.BasketIdentifierModelSequence.BasketIdentifierModelSequenceImpl;
import fpml.confirmation.BasketName;
import fpml.confirmation.meta.BasketIdentifierModelSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BasketIdentifierModelSequence", builder=BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilderImpl.class, version="${project.version}")
public interface BasketIdentifierModelSequence extends RosettaModelObject {

	BasketIdentifierModelSequenceMeta metaData = new BasketIdentifierModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 */
	BasketName getBasketName();
	/**
	 * A CDS basket identifier
	 */
	List<? extends BasketId> getBasketId();

	/*********************** Build Methods  ***********************/
	BasketIdentifierModelSequence build();
	
	BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder toBuilder();
	
	static BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder builder() {
		return new BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketIdentifierModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketIdentifierModelSequence> getType() {
		return BasketIdentifierModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketName"), processor, BasketName.class, getBasketName());
		processRosetta(path.newSubPath("basketId"), processor, BasketId.class, getBasketId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketIdentifierModelSequenceBuilder extends BasketIdentifierModelSequence, RosettaModelObjectBuilder {
		BasketName.BasketNameBuilder getOrCreateBasketName();
		BasketName.BasketNameBuilder getBasketName();
		BasketId.BasketIdBuilder getOrCreateBasketId(int _index);
		List<? extends BasketId.BasketIdBuilder> getBasketId();
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder setBasketName(BasketName basketName);
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(BasketId basketId0);
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(BasketId basketId1, int _idx);
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(List<? extends BasketId> basketId2);
		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder setBasketId(List<? extends BasketId> basketId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketName"), processor, BasketName.BasketNameBuilder.class, getBasketName());
			processRosetta(path.newSubPath("basketId"), processor, BasketId.BasketIdBuilder.class, getBasketId());
		}
		

		BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of BasketIdentifierModelSequence  ***********************/
	class BasketIdentifierModelSequenceImpl implements BasketIdentifierModelSequence {
		private final BasketName basketName;
		private final List<? extends BasketId> basketId;
		
		protected BasketIdentifierModelSequenceImpl(BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder builder) {
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketName")
		public BasketName getBasketName() {
			return basketName;
		}
		
		@Override
		@RosettaAttribute("basketId")
		public List<? extends BasketId> getBasketId() {
			return basketId;
		}
		
		@Override
		public BasketIdentifierModelSequence build() {
			return this;
		}
		
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder toBuilder() {
			BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder builder) {
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketIdentifierModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketIdentifierModelSequence {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketIdentifierModelSequence  ***********************/
	class BasketIdentifierModelSequenceBuilderImpl implements BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder {
	
		protected BasketName.BasketNameBuilder basketName;
		protected List<BasketId.BasketIdBuilder> basketId = new ArrayList<>();
	
		public BasketIdentifierModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("basketName")
		public BasketName.BasketNameBuilder getBasketName() {
			return basketName;
		}
		
		@Override
		public BasketName.BasketNameBuilder getOrCreateBasketName() {
			BasketName.BasketNameBuilder result;
			if (basketName!=null) {
				result = basketName;
			}
			else {
				result = basketName = BasketName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketId")
		public List<? extends BasketId.BasketIdBuilder> getBasketId() {
			return basketId;
		}
		
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
		@RosettaAttribute("basketName")
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder setBasketName(BasketName basketName) {
			this.basketName = basketName==null?null:basketName.toBuilder();
			return this;
		}
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(BasketId basketId) {
			if (basketId!=null) this.basketId.add(basketId.toBuilder());
			return this;
		}
		
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(BasketId basketId, int _idx) {
			getIndex(this.basketId, _idx, () -> basketId.toBuilder());
			return this;
		}
		@Override 
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder addBasketId(List<? extends BasketId> basketIds) {
			if (basketIds != null) {
				for (BasketId toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("basketId")
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder setBasketId(List<? extends BasketId> basketIds) {
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
		public BasketIdentifierModelSequence build() {
			return new BasketIdentifierModelSequence.BasketIdentifierModelSequenceImpl(this);
		}
		
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder prune() {
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			basketId = basketId.stream().filter(b->b!=null).<BasketId.BasketIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketName()!=null && getBasketName().hasData()) return true;
			if (getBasketId()!=null && getBasketId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder o = (BasketIdentifierModelSequence.BasketIdentifierModelSequenceBuilder) other;
			
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketIdentifierModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketIdentifierModelSequenceBuilder {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId +
			'}';
		}
	}
}
