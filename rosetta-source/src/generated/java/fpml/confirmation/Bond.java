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
import fpml.confirmation.Bond;
import fpml.confirmation.Bond.BondBuilder;
import fpml.confirmation.Bond.BondBuilderImpl;
import fpml.confirmation.Bond.BondImpl;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.BondMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is a series or a class of bonds. An exchange traded bond.
 * @version ${project.version}
 */
@RosettaDataType(value="Bond", builder=Bond.BondBuilderImpl.class, version="${project.version}")
public interface Bond extends UnderlyingAssetType {

	BondMeta metaData = new BondMeta();

	/*********************** Getter Methods  ***********************/
	FixedIncomeSecurityContentModel getFixedIncomeSecurityContentModel();
	/**
	 * Specifies the nominal amount of a fixed income security or convertible bond.
	 */
	BigDecimal getParValue();
	/**
	 * Specifies the total amount of the issue. Corresponds to the par value multiplied by the number of issued security.
	 */
	BigDecimal getFaceAmount();
	BondCalculationModel getBondCalculationModel();

	/*********************** Build Methods  ***********************/
	Bond build();
	
	Bond.BondBuilder toBuilder();
	
	static Bond.BondBuilder builder() {
		return new Bond.BondBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Bond> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Bond> getType() {
		return Bond.class;
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
		processRosetta(path.newSubPath("fixedIncomeSecurityContentModel"), processor, FixedIncomeSecurityContentModel.class, getFixedIncomeSecurityContentModel());
		processor.processBasic(path.newSubPath("parValue"), BigDecimal.class, getParValue(), this);
		processor.processBasic(path.newSubPath("faceAmount"), BigDecimal.class, getFaceAmount(), this);
		processRosetta(path.newSubPath("bondCalculationModel"), processor, BondCalculationModel.class, getBondCalculationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondBuilder extends Bond, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getOrCreateFixedIncomeSecurityContentModel();
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getFixedIncomeSecurityContentModel();
		BondCalculationModel.BondCalculationModelBuilder getOrCreateBondCalculationModel();
		BondCalculationModel.BondCalculationModelBuilder getBondCalculationModel();
		Bond.BondBuilder setId(String id);
		Bond.BondBuilder addInstrumentId(InstrumentId instrumentId0);
		Bond.BondBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Bond.BondBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Bond.BondBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Bond.BondBuilder setDescription(String description);
		Bond.BondBuilder setCurrency(IdentifiedCurrency currency);
		Bond.BondBuilder setExchangeId(ExchangeId exchangeId);
		Bond.BondBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Bond.BondBuilder setDefinition(ProductReference definition);
		Bond.BondBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel);
		Bond.BondBuilder setParValue(BigDecimal parValue);
		Bond.BondBuilder setFaceAmount(BigDecimal faceAmount);
		Bond.BondBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("fixedIncomeSecurityContentModel"), processor, FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder.class, getFixedIncomeSecurityContentModel());
			processor.processBasic(path.newSubPath("parValue"), BigDecimal.class, getParValue(), this);
			processor.processBasic(path.newSubPath("faceAmount"), BigDecimal.class, getFaceAmount(), this);
			processRosetta(path.newSubPath("bondCalculationModel"), processor, BondCalculationModel.BondCalculationModelBuilder.class, getBondCalculationModel());
		}
		

		Bond.BondBuilder prune();
	}

	/*********************** Immutable Implementation of Bond  ***********************/
	class BondImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements Bond {
		private final FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel;
		private final BigDecimal parValue;
		private final BigDecimal faceAmount;
		private final BondCalculationModel bondCalculationModel;
		
		protected BondImpl(Bond.BondBuilder builder) {
			super(builder);
			this.fixedIncomeSecurityContentModel = ofNullable(builder.getFixedIncomeSecurityContentModel()).map(f->f.build()).orElse(null);
			this.parValue = builder.getParValue();
			this.faceAmount = builder.getFaceAmount();
			this.bondCalculationModel = ofNullable(builder.getBondCalculationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public FixedIncomeSecurityContentModel getFixedIncomeSecurityContentModel() {
			return fixedIncomeSecurityContentModel;
		}
		
		@Override
		@RosettaAttribute("parValue")
		public BigDecimal getParValue() {
			return parValue;
		}
		
		@Override
		@RosettaAttribute("faceAmount")
		public BigDecimal getFaceAmount() {
			return faceAmount;
		}
		
		@Override
		@RosettaAttribute("bondCalculationModel")
		public BondCalculationModel getBondCalculationModel() {
			return bondCalculationModel;
		}
		
		@Override
		public Bond build() {
			return this;
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			Bond.BondBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Bond.BondBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedIncomeSecurityContentModel()).ifPresent(builder::setFixedIncomeSecurityContentModel);
			ofNullable(getParValue()).ifPresent(builder::setParValue);
			ofNullable(getFaceAmount()).ifPresent(builder::setFaceAmount);
			ofNullable(getBondCalculationModel()).ifPresent(builder::setBondCalculationModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Bond _that = getType().cast(o);
		
			if (!Objects.equals(fixedIncomeSecurityContentModel, _that.getFixedIncomeSecurityContentModel())) return false;
			if (!Objects.equals(parValue, _that.getParValue())) return false;
			if (!Objects.equals(faceAmount, _that.getFaceAmount())) return false;
			if (!Objects.equals(bondCalculationModel, _that.getBondCalculationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedIncomeSecurityContentModel != null ? fixedIncomeSecurityContentModel.hashCode() : 0);
			_result = 31 * _result + (parValue != null ? parValue.hashCode() : 0);
			_result = 31 * _result + (faceAmount != null ? faceAmount.hashCode() : 0);
			_result = 31 * _result + (bondCalculationModel != null ? bondCalculationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Bond {" +
				"fixedIncomeSecurityContentModel=" + this.fixedIncomeSecurityContentModel + ", " +
				"parValue=" + this.parValue + ", " +
				"faceAmount=" + this.faceAmount + ", " +
				"bondCalculationModel=" + this.bondCalculationModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Bond  ***********************/
	class BondBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements Bond.BondBuilder {
	
		protected FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder fixedIncomeSecurityContentModel;
		protected BigDecimal parValue;
		protected BigDecimal faceAmount;
		protected BondCalculationModel.BondCalculationModelBuilder bondCalculationModel;
	
		public BondBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getFixedIncomeSecurityContentModel() {
			return fixedIncomeSecurityContentModel;
		}
		
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder getOrCreateFixedIncomeSecurityContentModel() {
			FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder result;
			if (fixedIncomeSecurityContentModel!=null) {
				result = fixedIncomeSecurityContentModel;
			}
			else {
				result = fixedIncomeSecurityContentModel = FixedIncomeSecurityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parValue")
		public BigDecimal getParValue() {
			return parValue;
		}
		
		@Override
		@RosettaAttribute("faceAmount")
		public BigDecimal getFaceAmount() {
			return faceAmount;
		}
		
		@Override
		@RosettaAttribute("bondCalculationModel")
		public BondCalculationModel.BondCalculationModelBuilder getBondCalculationModel() {
			return bondCalculationModel;
		}
		
		@Override
		public BondCalculationModel.BondCalculationModelBuilder getOrCreateBondCalculationModel() {
			BondCalculationModel.BondCalculationModelBuilder result;
			if (bondCalculationModel!=null) {
				result = bondCalculationModel;
			}
			else {
				result = bondCalculationModel = BondCalculationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Bond.BondBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Bond.BondBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Bond.BondBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Bond.BondBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public Bond.BondBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Bond.BondBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Bond.BondBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Bond.BondBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Bond.BondBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Bond.BondBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public Bond.BondBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			this.fixedIncomeSecurityContentModel = fixedIncomeSecurityContentModel==null?null:fixedIncomeSecurityContentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parValue")
		public Bond.BondBuilder setParValue(BigDecimal parValue) {
			this.parValue = parValue==null?null:parValue;
			return this;
		}
		@Override
		@RosettaAttribute("faceAmount")
		public Bond.BondBuilder setFaceAmount(BigDecimal faceAmount) {
			this.faceAmount = faceAmount==null?null:faceAmount;
			return this;
		}
		@Override
		@RosettaAttribute("bondCalculationModel")
		public Bond.BondBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel) {
			this.bondCalculationModel = bondCalculationModel==null?null:bondCalculationModel.toBuilder();
			return this;
		}
		
		@Override
		public Bond build() {
			return new Bond.BondImpl(this);
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder prune() {
			super.prune();
			if (fixedIncomeSecurityContentModel!=null && !fixedIncomeSecurityContentModel.prune().hasData()) fixedIncomeSecurityContentModel = null;
			if (bondCalculationModel!=null && !bondCalculationModel.prune().hasData()) bondCalculationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedIncomeSecurityContentModel()!=null && getFixedIncomeSecurityContentModel().hasData()) return true;
			if (getParValue()!=null) return true;
			if (getFaceAmount()!=null) return true;
			if (getBondCalculationModel()!=null && getBondCalculationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Bond.BondBuilder o = (Bond.BondBuilder) other;
			
			merger.mergeRosetta(getFixedIncomeSecurityContentModel(), o.getFixedIncomeSecurityContentModel(), this::setFixedIncomeSecurityContentModel);
			merger.mergeRosetta(getBondCalculationModel(), o.getBondCalculationModel(), this::setBondCalculationModel);
			
			merger.mergeBasic(getParValue(), o.getParValue(), this::setParValue);
			merger.mergeBasic(getFaceAmount(), o.getFaceAmount(), this::setFaceAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Bond _that = getType().cast(o);
		
			if (!Objects.equals(fixedIncomeSecurityContentModel, _that.getFixedIncomeSecurityContentModel())) return false;
			if (!Objects.equals(parValue, _that.getParValue())) return false;
			if (!Objects.equals(faceAmount, _that.getFaceAmount())) return false;
			if (!Objects.equals(bondCalculationModel, _that.getBondCalculationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedIncomeSecurityContentModel != null ? fixedIncomeSecurityContentModel.hashCode() : 0);
			_result = 31 * _result + (parValue != null ? parValue.hashCode() : 0);
			_result = 31 * _result + (faceAmount != null ? faceAmount.hashCode() : 0);
			_result = 31 * _result + (bondCalculationModel != null ? bondCalculationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondBuilder {" +
				"fixedIncomeSecurityContentModel=" + this.fixedIncomeSecurityContentModel + ", " +
				"parValue=" + this.parValue + ", " +
				"faceAmount=" + this.faceAmount + ", " +
				"bondCalculationModel=" + this.bondCalculationModel +
			'}' + " " + super.toString();
		}
	}
}
