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
import fpml.confirmation.FixedPrice;
import fpml.confirmation.FixedPrice.FixedPriceBuilder;
import fpml.confirmation.FixedPrice.FixedPriceBuilderImpl;
import fpml.confirmation.FixedPrice.FixedPriceImpl;
import fpml.confirmation.PriceModel;
import fpml.confirmation.SettlementPeriodsFixedPrice;
import fpml.confirmation.SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder;
import fpml.confirmation.SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl;
import fpml.confirmation.SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceImpl;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.SettlementPeriodsFixedPriceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the Fixed Price applicable to a range or ranges of Settlement Periods.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriodsFixedPrice", builder=SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl.class, version="${project.version}")
public interface SettlementPeriodsFixedPrice extends FixedPrice {

	SettlementPeriodsFixedPriceMeta metaData = new SettlementPeriodsFixedPriceMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	SettlementPeriodsFixedPrice build();
	
	SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder();
	
	static SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder() {
		return new SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsFixedPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodsFixedPrice> getType() {
		return SettlementPeriodsFixedPrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("priceModel"), processor, PriceModel.class, getPriceModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsFixedPriceBuilder extends SettlementPeriodsFixedPrice, FixedPrice.FixedPriceBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPrice(BigDecimal price);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceModel(PriceModel priceModel);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setId(String id);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("priceModel"), processor, PriceModel.PriceModelBuilder.class, getPriceModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsFixedPrice  ***********************/
	class SettlementPeriodsFixedPriceImpl extends FixedPrice.FixedPriceImpl implements SettlementPeriodsFixedPrice {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected SettlementPeriodsFixedPriceImpl(SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsFixedPrice build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder() {
			SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsFixedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsFixedPrice {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsFixedPrice  ***********************/
	class SettlementPeriodsFixedPriceBuilderImpl extends FixedPrice.FixedPriceBuilderImpl  implements SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public SettlementPeriodsFixedPriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index) {
		
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder result;
			return getIndex(settlementPeriodsReference, _index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@Override
		@RosettaAttribute("price")
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPrice(BigDecimal price) {
			this.price = price==null?null:price;
			return this;
		}
		@Override
		@RosettaAttribute("priceModel")
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setPriceModel(PriceModel priceModel) {
			this.priceModel = priceModel==null?null:priceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null)  {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SettlementPeriodsFixedPrice build() {
			return new SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceImpl(this);
		}
		
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder prune() {
			super.prune();
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder o = (SettlementPeriodsFixedPrice.SettlementPeriodsFixedPriceBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsFixedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsFixedPriceBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
