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
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Reference;
import fpml.confirmation.TradeLegPriceChange;
import fpml.confirmation.TradeLegPriceChange.TradeLegPriceChangeBuilder;
import fpml.confirmation.TradeLegPriceChange.TradeLegPriceChangeBuilderImpl;
import fpml.confirmation.TradeLegPriceChange.TradeLegPriceChangeImpl;
import fpml.confirmation.meta.TradeLegPriceChangeMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a change to the size of a single leg or stream of a trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeLegPriceChange", builder=TradeLegPriceChange.TradeLegPriceChangeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeLegPriceChange extends RosettaModelObject {

	TradeLegPriceChangeMeta metaData = new TradeLegPriceChangeMeta();

	/*********************** Getter Methods  ***********************/
	Reference getPriceReference();
	/**
	 * Identification of the underlying asset, using public and/or private identifiers.
	 */
	List<? extends InstrumentId> getInstrumentId();
	BigDecimal getPriceChangeAmount();
	BigDecimal getNewPrice();

	/*********************** Build Methods  ***********************/
	TradeLegPriceChange build();
	
	TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder();
	
	static TradeLegPriceChange.TradeLegPriceChangeBuilder builder() {
		return new TradeLegPriceChange.TradeLegPriceChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegPriceChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegPriceChange> getType() {
		return TradeLegPriceChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("priceReference"), processor, Reference.class, getPriceReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("priceChangeAmount"), BigDecimal.class, getPriceChangeAmount(), this);
		processor.processBasic(path.newSubPath("newPrice"), BigDecimal.class, getNewPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegPriceChangeBuilder extends TradeLegPriceChange, RosettaModelObjectBuilder {
		Reference.ReferenceBuilder getOrCreatePriceReference();
		Reference.ReferenceBuilder getPriceReference();
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int _index);
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceReference(Reference priceReference);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId0);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceChangeAmount(BigDecimal priceChangeAmount);
		TradeLegPriceChange.TradeLegPriceChangeBuilder setNewPrice(BigDecimal newPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("priceReference"), processor, Reference.ReferenceBuilder.class, getPriceReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("priceChangeAmount"), BigDecimal.class, getPriceChangeAmount(), this);
			processor.processBasic(path.newSubPath("newPrice"), BigDecimal.class, getNewPrice(), this);
		}
		

		TradeLegPriceChange.TradeLegPriceChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegPriceChange  ***********************/
	class TradeLegPriceChangeImpl implements TradeLegPriceChange {
		private final Reference priceReference;
		private final List<? extends InstrumentId> instrumentId;
		private final BigDecimal priceChangeAmount;
		private final BigDecimal newPrice;
		
		protected TradeLegPriceChangeImpl(TradeLegPriceChange.TradeLegPriceChangeBuilder builder) {
			this.priceReference = ofNullable(builder.getPriceReference()).map(f->f.build()).orElse(null);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.priceChangeAmount = builder.getPriceChangeAmount();
			this.newPrice = builder.getNewPrice();
		}
		
		@Override
		@RosettaAttribute("priceReference")
		public Reference getPriceReference() {
			return priceReference;
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("priceChangeAmount")
		public BigDecimal getPriceChangeAmount() {
			return priceChangeAmount;
		}
		
		@Override
		@RosettaAttribute("newPrice")
		public BigDecimal getNewPrice() {
			return newPrice;
		}
		
		@Override
		public TradeLegPriceChange build() {
			return this;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder() {
			TradeLegPriceChange.TradeLegPriceChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegPriceChange.TradeLegPriceChangeBuilder builder) {
			ofNullable(getPriceReference()).ifPresent(builder::setPriceReference);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getPriceChangeAmount()).ifPresent(builder::setPriceChangeAmount);
			ofNullable(getNewPrice()).ifPresent(builder::setNewPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegPriceChange _that = getType().cast(o);
		
			if (!Objects.equals(priceReference, _that.getPriceReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(priceChangeAmount, _that.getPriceChangeAmount())) return false;
			if (!Objects.equals(newPrice, _that.getNewPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceReference != null ? priceReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (priceChangeAmount != null ? priceChangeAmount.hashCode() : 0);
			_result = 31 * _result + (newPrice != null ? newPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegPriceChange {" +
				"priceReference=" + this.priceReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"priceChangeAmount=" + this.priceChangeAmount + ", " +
				"newPrice=" + this.newPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegPriceChange  ***********************/
	class TradeLegPriceChangeBuilderImpl implements TradeLegPriceChange.TradeLegPriceChangeBuilder {
	
		protected Reference.ReferenceBuilder priceReference;
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected BigDecimal priceChangeAmount;
		protected BigDecimal newPrice;
	
		public TradeLegPriceChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("priceReference")
		public Reference.ReferenceBuilder getPriceReference() {
			return priceReference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreatePriceReference() {
			Reference.ReferenceBuilder result;
			if (priceReference!=null) {
				result = priceReference;
			}
			else {
				result = priceReference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int _index) {
		
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			InstrumentId.InstrumentIdBuilder result;
			return getIndex(instrumentId, _index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("priceChangeAmount")
		public BigDecimal getPriceChangeAmount() {
			return priceChangeAmount;
		}
		
		@Override
		@RosettaAttribute("newPrice")
		public BigDecimal getNewPrice() {
			return newPrice;
		}
		
		@Override
		@RosettaAttribute("priceReference")
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceReference(Reference priceReference) {
			this.priceReference = priceReference==null?null:priceReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public TradeLegPriceChange.TradeLegPriceChangeBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("priceChangeAmount")
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setPriceChangeAmount(BigDecimal priceChangeAmount) {
			this.priceChangeAmount = priceChangeAmount==null?null:priceChangeAmount;
			return this;
		}
		@Override
		@RosettaAttribute("newPrice")
		public TradeLegPriceChange.TradeLegPriceChangeBuilder setNewPrice(BigDecimal newPrice) {
			this.newPrice = newPrice==null?null:newPrice;
			return this;
		}
		
		@Override
		public TradeLegPriceChange build() {
			return new TradeLegPriceChange.TradeLegPriceChangeImpl(this);
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder prune() {
			if (priceReference!=null && !priceReference.prune().hasData()) priceReference = null;
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceReference()!=null && getPriceReference().hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPriceChangeAmount()!=null) return true;
			if (getNewPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegPriceChange.TradeLegPriceChangeBuilder o = (TradeLegPriceChange.TradeLegPriceChangeBuilder) other;
			
			merger.mergeRosetta(getPriceReference(), o.getPriceReference(), this::setPriceReference);
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			
			merger.mergeBasic(getPriceChangeAmount(), o.getPriceChangeAmount(), this::setPriceChangeAmount);
			merger.mergeBasic(getNewPrice(), o.getNewPrice(), this::setNewPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegPriceChange _that = getType().cast(o);
		
			if (!Objects.equals(priceReference, _that.getPriceReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(priceChangeAmount, _that.getPriceChangeAmount())) return false;
			if (!Objects.equals(newPrice, _that.getNewPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceReference != null ? priceReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (priceChangeAmount != null ? priceChangeAmount.hashCode() : 0);
			_result = 31 * _result + (newPrice != null ? newPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegPriceChangeBuilder {" +
				"priceReference=" + this.priceReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"priceChangeAmount=" + this.priceChangeAmount + ", " +
				"newPrice=" + this.newPrice +
			'}';
		}
	}
}
