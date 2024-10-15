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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.Bond;
import fpml.confirmation.Bond.BondBuilder;
import fpml.confirmation.Bond.BondBuilderImpl;
import fpml.confirmation.Bond.BondImpl;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.ConvertibleBond.ConvertibleBondBuilder;
import fpml.confirmation.ConvertibleBond.ConvertibleBondBuilderImpl;
import fpml.confirmation.ConvertibleBond.ConvertibleBondImpl;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.ConvertibleBondMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is a convertible bond.
 * @version ${project.version}
 */
@RosettaDataType(value="ConvertibleBond", builder=ConvertibleBond.ConvertibleBondBuilderImpl.class, version="${project.version}")
public interface ConvertibleBond extends Bond {

	ConvertibleBondMeta metaData = new ConvertibleBondMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the equity in which the convertible bond can be converted.
	 */
	EquityAsset getUnderlyingEquity();
	/**
	 * Earlier date between the convertible bond put dates and its maturity date.
	 */
	Date getRedemptionDate();

	/*********************** Build Methods  ***********************/
	ConvertibleBond build();
	
	ConvertibleBond.ConvertibleBondBuilder toBuilder();
	
	static ConvertibleBond.ConvertibleBondBuilder builder() {
		return new ConvertibleBond.ConvertibleBondBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConvertibleBond> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConvertibleBond> getType() {
		return ConvertibleBond.class;
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
		processRosetta(path.newSubPath("underlyingEquity"), processor, EquityAsset.class, getUnderlyingEquity());
		processor.processBasic(path.newSubPath("redemptionDate"), Date.class, getRedemptionDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConvertibleBondBuilder extends ConvertibleBond, Bond.BondBuilder {
		EquityAsset.EquityAssetBuilder getOrCreateUnderlyingEquity();
		EquityAsset.EquityAssetBuilder getUnderlyingEquity();
		ConvertibleBond.ConvertibleBondBuilder setId(String id);
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId0);
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ConvertibleBond.ConvertibleBondBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ConvertibleBond.ConvertibleBondBuilder setDescription(String description);
		ConvertibleBond.ConvertibleBondBuilder setCurrency(IdentifiedCurrency currency);
		ConvertibleBond.ConvertibleBondBuilder setExchangeId(ExchangeId exchangeId);
		ConvertibleBond.ConvertibleBondBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ConvertibleBond.ConvertibleBondBuilder setDefinition(ProductReference definition);
		ConvertibleBond.ConvertibleBondBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel);
		ConvertibleBond.ConvertibleBondBuilder setParValue(BigDecimal parValue);
		ConvertibleBond.ConvertibleBondBuilder setFaceAmount(BigDecimal faceAmount);
		ConvertibleBond.ConvertibleBondBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel);
		ConvertibleBond.ConvertibleBondBuilder setUnderlyingEquity(EquityAsset underlyingEquity);
		ConvertibleBond.ConvertibleBondBuilder setRedemptionDate(Date redemptionDate);

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
			processRosetta(path.newSubPath("underlyingEquity"), processor, EquityAsset.EquityAssetBuilder.class, getUnderlyingEquity());
			processor.processBasic(path.newSubPath("redemptionDate"), Date.class, getRedemptionDate(), this);
		}
		

		ConvertibleBond.ConvertibleBondBuilder prune();
	}

	/*********************** Immutable Implementation of ConvertibleBond  ***********************/
	class ConvertibleBondImpl extends Bond.BondImpl implements ConvertibleBond {
		private final EquityAsset underlyingEquity;
		private final Date redemptionDate;
		
		protected ConvertibleBondImpl(ConvertibleBond.ConvertibleBondBuilder builder) {
			super(builder);
			this.underlyingEquity = ofNullable(builder.getUnderlyingEquity()).map(f->f.build()).orElse(null);
			this.redemptionDate = builder.getRedemptionDate();
		}
		
		@Override
		@RosettaAttribute("underlyingEquity")
		public EquityAsset getUnderlyingEquity() {
			return underlyingEquity;
		}
		
		@Override
		@RosettaAttribute("redemptionDate")
		public Date getRedemptionDate() {
			return redemptionDate;
		}
		
		@Override
		public ConvertibleBond build() {
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder toBuilder() {
			ConvertibleBond.ConvertibleBondBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConvertibleBond.ConvertibleBondBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyingEquity()).ifPresent(builder::setUnderlyingEquity);
			ofNullable(getRedemptionDate()).ifPresent(builder::setRedemptionDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConvertibleBond _that = getType().cast(o);
		
			if (!Objects.equals(underlyingEquity, _that.getUnderlyingEquity())) return false;
			if (!Objects.equals(redemptionDate, _that.getRedemptionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyingEquity != null ? underlyingEquity.hashCode() : 0);
			_result = 31 * _result + (redemptionDate != null ? redemptionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConvertibleBond {" +
				"underlyingEquity=" + this.underlyingEquity + ", " +
				"redemptionDate=" + this.redemptionDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConvertibleBond  ***********************/
	class ConvertibleBondBuilderImpl extends Bond.BondBuilderImpl  implements ConvertibleBond.ConvertibleBondBuilder {
	
		protected EquityAsset.EquityAssetBuilder underlyingEquity;
		protected Date redemptionDate;
	
		public ConvertibleBondBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyingEquity")
		public EquityAsset.EquityAssetBuilder getUnderlyingEquity() {
			return underlyingEquity;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder getOrCreateUnderlyingEquity() {
			EquityAsset.EquityAssetBuilder result;
			if (underlyingEquity!=null) {
				result = underlyingEquity;
			}
			else {
				result = underlyingEquity = EquityAsset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("redemptionDate")
		public Date getRedemptionDate() {
			return redemptionDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public ConvertibleBond.ConvertibleBondBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public ConvertibleBond.ConvertibleBondBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ConvertibleBond.ConvertibleBondBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ConvertibleBond.ConvertibleBondBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ConvertibleBond.ConvertibleBondBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ConvertibleBond.ConvertibleBondBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ConvertibleBond.ConvertibleBondBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedIncomeSecurityContentModel")
		public ConvertibleBond.ConvertibleBondBuilder setFixedIncomeSecurityContentModel(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			this.fixedIncomeSecurityContentModel = fixedIncomeSecurityContentModel==null?null:fixedIncomeSecurityContentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parValue")
		public ConvertibleBond.ConvertibleBondBuilder setParValue(BigDecimal parValue) {
			this.parValue = parValue==null?null:parValue;
			return this;
		}
		@Override
		@RosettaAttribute("faceAmount")
		public ConvertibleBond.ConvertibleBondBuilder setFaceAmount(BigDecimal faceAmount) {
			this.faceAmount = faceAmount==null?null:faceAmount;
			return this;
		}
		@Override
		@RosettaAttribute("bondCalculationModel")
		public ConvertibleBond.ConvertibleBondBuilder setBondCalculationModel(BondCalculationModel bondCalculationModel) {
			this.bondCalculationModel = bondCalculationModel==null?null:bondCalculationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyingEquity")
		public ConvertibleBond.ConvertibleBondBuilder setUnderlyingEquity(EquityAsset underlyingEquity) {
			this.underlyingEquity = underlyingEquity==null?null:underlyingEquity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("redemptionDate")
		public ConvertibleBond.ConvertibleBondBuilder setRedemptionDate(Date redemptionDate) {
			this.redemptionDate = redemptionDate==null?null:redemptionDate;
			return this;
		}
		
		@Override
		public ConvertibleBond build() {
			return new ConvertibleBond.ConvertibleBondImpl(this);
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder prune() {
			super.prune();
			if (underlyingEquity!=null && !underlyingEquity.prune().hasData()) underlyingEquity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyingEquity()!=null && getUnderlyingEquity().hasData()) return true;
			if (getRedemptionDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConvertibleBond.ConvertibleBondBuilder o = (ConvertibleBond.ConvertibleBondBuilder) other;
			
			merger.mergeRosetta(getUnderlyingEquity(), o.getUnderlyingEquity(), this::setUnderlyingEquity);
			
			merger.mergeBasic(getRedemptionDate(), o.getRedemptionDate(), this::setRedemptionDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConvertibleBond _that = getType().cast(o);
		
			if (!Objects.equals(underlyingEquity, _that.getUnderlyingEquity())) return false;
			if (!Objects.equals(redemptionDate, _that.getRedemptionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyingEquity != null ? underlyingEquity.hashCode() : 0);
			_result = 31 * _result + (redemptionDate != null ? redemptionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConvertibleBondBuilder {" +
				"underlyingEquity=" + this.underlyingEquity + ", " +
				"redemptionDate=" + this.redemptionDate +
			'}' + " " + super.toString();
		}
	}
}
