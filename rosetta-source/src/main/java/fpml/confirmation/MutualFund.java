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
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.MutualFund;
import fpml.confirmation.MutualFund.MutualFundBuilder;
import fpml.confirmation.MutualFund.MutualFundBuilderImpl;
import fpml.confirmation.MutualFund.MutualFundImpl;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.MutualFundMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the class of unit issued by a fund.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MutualFund", builder=MutualFund.MutualFundBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MutualFund extends UnderlyingAssetType {

	MutualFundMeta metaData = new MutualFundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Boolean indicator to specify whether the mutual fund is an open-ended mutual fund.
	 */
	Boolean getOpenEndedFund();
	/**
	 * Specifies the fund manager that is in charge of the fund.
	 */
	String getFundManager();

	/*********************** Build Methods  ***********************/
	MutualFund build();
	
	MutualFund.MutualFundBuilder toBuilder();
	
	static MutualFund.MutualFundBuilder builder() {
		return new MutualFund.MutualFundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutualFund> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MutualFund> getType() {
		return MutualFund.class;
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
		processor.processBasic(path.newSubPath("openEndedFund"), Boolean.class, getOpenEndedFund(), this);
		processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutualFundBuilder extends MutualFund, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		MutualFund.MutualFundBuilder setId(String id);
		MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId0);
		MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		MutualFund.MutualFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		MutualFund.MutualFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		MutualFund.MutualFundBuilder setDescription(String description);
		MutualFund.MutualFundBuilder setCurrency(IdentifiedCurrency currency);
		MutualFund.MutualFundBuilder setExchangeId(ExchangeId exchangeId);
		MutualFund.MutualFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		MutualFund.MutualFundBuilder setDefinition(ProductReference definition);
		MutualFund.MutualFundBuilder setOpenEndedFund(Boolean openEndedFund);
		MutualFund.MutualFundBuilder setFundManager(String fundManager);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processor.processBasic(path.newSubPath("openEndedFund"), Boolean.class, getOpenEndedFund(), this);
			processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
		}
		

		MutualFund.MutualFundBuilder prune();
	}

	/*********************** Immutable Implementation of MutualFund  ***********************/
	class MutualFundImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements MutualFund {
		private final Boolean openEndedFund;
		private final String fundManager;
		
		protected MutualFundImpl(MutualFund.MutualFundBuilder builder) {
			super(builder);
			this.openEndedFund = builder.getOpenEndedFund();
			this.fundManager = builder.getFundManager();
		}
		
		@Override
		@RosettaAttribute("openEndedFund")
		public Boolean getOpenEndedFund() {
			return openEndedFund;
		}
		
		@Override
		@RosettaAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		public MutualFund build() {
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder toBuilder() {
			MutualFund.MutualFundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutualFund.MutualFundBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOpenEndedFund()).ifPresent(builder::setOpenEndedFund);
			ofNullable(getFundManager()).ifPresent(builder::setFundManager);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MutualFund _that = getType().cast(o);
		
			if (!Objects.equals(openEndedFund, _that.getOpenEndedFund())) return false;
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openEndedFund != null ? openEndedFund.hashCode() : 0);
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualFund {" +
				"openEndedFund=" + this.openEndedFund + ", " +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MutualFund  ***********************/
	class MutualFundBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements MutualFund.MutualFundBuilder {
	
		protected Boolean openEndedFund;
		protected String fundManager;
	
		public MutualFundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("openEndedFund")
		public Boolean getOpenEndedFund() {
			return openEndedFund;
		}
		
		@Override
		@RosettaAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		@RosettaAttribute("id")
		public MutualFund.MutualFundBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public MutualFund.MutualFundBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public MutualFund.MutualFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MutualFund.MutualFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public MutualFund.MutualFundBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public MutualFund.MutualFundBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public MutualFund.MutualFundBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public MutualFund.MutualFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public MutualFund.MutualFundBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("openEndedFund")
		public MutualFund.MutualFundBuilder setOpenEndedFund(Boolean openEndedFund) {
			this.openEndedFund = openEndedFund==null?null:openEndedFund;
			return this;
		}
		@Override
		@RosettaAttribute("fundManager")
		public MutualFund.MutualFundBuilder setFundManager(String fundManager) {
			this.fundManager = fundManager==null?null:fundManager;
			return this;
		}
		
		@Override
		public MutualFund build() {
			return new MutualFund.MutualFundImpl(this);
		}
		
		@Override
		public MutualFund.MutualFundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualFund.MutualFundBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOpenEndedFund()!=null) return true;
			if (getFundManager()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualFund.MutualFundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MutualFund.MutualFundBuilder o = (MutualFund.MutualFundBuilder) other;
			
			
			merger.mergeBasic(getOpenEndedFund(), o.getOpenEndedFund(), this::setOpenEndedFund);
			merger.mergeBasic(getFundManager(), o.getFundManager(), this::setFundManager);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MutualFund _that = getType().cast(o);
		
			if (!Objects.equals(openEndedFund, _that.getOpenEndedFund())) return false;
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (openEndedFund != null ? openEndedFund.hashCode() : 0);
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualFundBuilder {" +
				"openEndedFund=" + this.openEndedFund + ", " +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}
}
