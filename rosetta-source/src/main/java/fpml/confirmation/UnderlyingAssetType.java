package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.IdentifiedAsset;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilder;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilderImpl;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.UnderlyingAssetTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all underlying assets.
 * @version ${project.version}
 */
@RosettaDataType(value="UnderlyingAssetType", builder=UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl.class, version="${project.version}")
public interface UnderlyingAssetType extends IdentifiedAsset {

	UnderlyingAssetTypeMeta metaData = new UnderlyingAssetTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Trading currency of the underlyer when transacted as a cash instrument.
	 */
	IdentifiedCurrency getCurrency();
	/**
	 * Identification of the exchange on which this asset is transacted for the purposes of calculating a contractural payoff. The term &quot;Exchange&quot; is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	ExchangeId getExchangeId();
	/**
	 * Identification of the clearance system associated with the transaction exchange.
	 */
	ClearanceSystem getClearanceSystem();
	/**
	 * An optional reference to a full FpML product that defines the simple product in greater detail. In case of inconsistency between the terms of the simple product and those of the detailed definition, the values in the simple product override those in the detailed definition.
	 */
	ProductReference getDefinition();

	/*********************** Build Methods  ***********************/
	UnderlyingAssetType build();
	
	UnderlyingAssetType.UnderlyingAssetTypeBuilder toBuilder();
	
	static UnderlyingAssetType.UnderlyingAssetTypeBuilder builder() {
		return new UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAssetType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyingAssetType> getType() {
		return UnderlyingAssetType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetTypeBuilder extends UnderlyingAssetType, IdentifiedAsset.IdentifiedAssetBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		ExchangeId.ExchangeIdBuilder getExchangeId();
		ClearanceSystem.ClearanceSystemBuilder getOrCreateClearanceSystem();
		ClearanceSystem.ClearanceSystemBuilder getClearanceSystem();
		ProductReference.ProductReferenceBuilder getOrCreateDefinition();
		ProductReference.ProductReferenceBuilder getDefinition();
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setId(String id);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(InstrumentId instrumentId0);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setDescription(String description);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setCurrency(IdentifiedCurrency currency);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setExchangeId(ExchangeId exchangeId);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		UnderlyingAssetType.UnderlyingAssetTypeBuilder setDefinition(ProductReference definition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
		}
		

		UnderlyingAssetType.UnderlyingAssetTypeBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAssetType  ***********************/
	class UnderlyingAssetTypeImpl extends IdentifiedAsset.IdentifiedAssetImpl implements UnderlyingAssetType {
		private final IdentifiedCurrency currency;
		private final ExchangeId exchangeId;
		private final ClearanceSystem clearanceSystem;
		private final ProductReference definition;
		
		protected UnderlyingAssetTypeImpl(UnderlyingAssetType.UnderlyingAssetTypeBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.clearanceSystem = ofNullable(builder.getClearanceSystem()).map(f->f.build()).orElse(null);
			this.definition = ofNullable(builder.getDefinition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		@RosettaAttribute("clearanceSystem")
		public ClearanceSystem getClearanceSystem() {
			return clearanceSystem;
		}
		
		@Override
		@RosettaAttribute("definition")
		public ProductReference getDefinition() {
			return definition;
		}
		
		@Override
		public UnderlyingAssetType build() {
			return this;
		}
		
		@Override
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder toBuilder() {
			UnderlyingAssetType.UnderlyingAssetTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAssetType.UnderlyingAssetTypeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getClearanceSystem()).ifPresent(builder::setClearanceSystem);
			ofNullable(getDefinition()).ifPresent(builder::setDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyingAssetType _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(clearanceSystem, _that.getClearanceSystem())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (clearanceSystem != null ? clearanceSystem.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetType {" +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"clearanceSystem=" + this.clearanceSystem + ", " +
				"definition=" + this.definition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyingAssetType  ***********************/
	class UnderlyingAssetTypeBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl  implements UnderlyingAssetType.UnderlyingAssetTypeBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
		protected ClearanceSystem.ClearanceSystemBuilder clearanceSystem;
		protected ProductReference.ProductReferenceBuilder definition;
	
		public UnderlyingAssetTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearanceSystem")
		public ClearanceSystem.ClearanceSystemBuilder getClearanceSystem() {
			return clearanceSystem;
		}
		
		@Override
		public ClearanceSystem.ClearanceSystemBuilder getOrCreateClearanceSystem() {
			ClearanceSystem.ClearanceSystemBuilder result;
			if (clearanceSystem!=null) {
				result = clearanceSystem;
			}
			else {
				result = clearanceSystem = ClearanceSystem.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("definition")
		public ProductReference.ProductReferenceBuilder getDefinition() {
			return definition;
		}
		
		@Override
		public ProductReference.ProductReferenceBuilder getOrCreateDefinition() {
			ProductReference.ProductReferenceBuilder result;
			if (definition!=null) {
				result = definition;
			}
			else {
				result = definition = ProductReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		@RosettaAttribute("description")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		
		@Override
		public UnderlyingAssetType build() {
			return new UnderlyingAssetType.UnderlyingAssetTypeImpl(this);
		}
		
		@Override
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			if (clearanceSystem!=null && !clearanceSystem.prune().hasData()) clearanceSystem = null;
			if (definition!=null && !definition.prune().hasData()) definition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			if (getClearanceSystem()!=null && getClearanceSystem().hasData()) return true;
			if (getDefinition()!=null && getDefinition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetType.UnderlyingAssetTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UnderlyingAssetType.UnderlyingAssetTypeBuilder o = (UnderlyingAssetType.UnderlyingAssetTypeBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getClearanceSystem(), o.getClearanceSystem(), this::setClearanceSystem);
			merger.mergeRosetta(getDefinition(), o.getDefinition(), this::setDefinition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyingAssetType _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(clearanceSystem, _that.getClearanceSystem())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (clearanceSystem != null ? clearanceSystem.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetTypeBuilder {" +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"clearanceSystem=" + this.clearanceSystem + ", " +
				"definition=" + this.definition +
			'}' + " " + super.toString();
		}
	}
}
