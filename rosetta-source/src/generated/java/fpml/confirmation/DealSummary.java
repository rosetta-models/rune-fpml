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
import fpml.confirmation.Currency;
import fpml.confirmation.DealIdentifier;
import fpml.confirmation.DealIdentifier.DealIdentifierBuilder;
import fpml.confirmation.DealIdentifier.DealIdentifierBuilderImpl;
import fpml.confirmation.DealIdentifier.DealIdentifierImpl;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealSummary;
import fpml.confirmation.DealSummary.DealSummaryBuilder;
import fpml.confirmation.DealSummary.DealSummaryBuilderImpl;
import fpml.confirmation.DealSummary.DealSummaryImpl;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.DealSummaryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A short form of a deal.
 * @version ${project.version}
 */
@RosettaDataType(value="DealSummary", builder=DealSummary.DealSummaryBuilderImpl.class, version="${project.version}")
public interface DealSummary extends DealIdentifier {

	DealSummaryMeta metaData = new DealSummaryMeta();

	/*********************** Getter Methods  ***********************/
	DealRolesModel getDealRolesModel();
	/**
	 * The credit agreement date is also known as the &#39;closing date&#39; (the date on which the agreement was signed). Funding of the facilities occurs either on or after (in the case of a Delayed Draw) the Credit Agreement date.
	 */
	Date getCreditAgreementDate();
	/**
	 * Deal denomination currency.
	 */
	Currency getCurrency();
	DealSummarySequence getDealSummarySequence();

	/*********************** Build Methods  ***********************/
	DealSummary build();
	
	DealSummary.DealSummaryBuilder toBuilder();
	
	static DealSummary.DealSummaryBuilder builder() {
		return new DealSummary.DealSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealSummary> getType() {
		return DealSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealRolesModel"), processor, DealRolesModel.class, getDealRolesModel());
		processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("dealSummarySequence"), processor, DealSummarySequence.class, getDealSummarySequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealSummaryBuilder extends DealSummary, DealIdentifier.DealIdentifierBuilder {
		DealRolesModel.DealRolesModelBuilder getOrCreateDealRolesModel();
		DealRolesModel.DealRolesModelBuilder getDealRolesModel();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		DealSummarySequence.DealSummarySequenceBuilder getOrCreateDealSummarySequence();
		DealSummarySequence.DealSummarySequenceBuilder getDealSummarySequence();
		DealSummary.DealSummaryBuilder setId(String id);
		DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId0);
		DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		DealSummary.DealSummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		DealSummary.DealSummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		DealSummary.DealSummaryBuilder setDescription(String description);
		DealSummary.DealSummaryBuilder setDealRolesModel(DealRolesModel dealRolesModel);
		DealSummary.DealSummaryBuilder setCreditAgreementDate(Date creditAgreementDate);
		DealSummary.DealSummaryBuilder setCurrency(Currency currency);
		DealSummary.DealSummaryBuilder setDealSummarySequence(DealSummarySequence dealSummarySequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealRolesModel"), processor, DealRolesModel.DealRolesModelBuilder.class, getDealRolesModel());
			processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("dealSummarySequence"), processor, DealSummarySequence.DealSummarySequenceBuilder.class, getDealSummarySequence());
		}
		

		DealSummary.DealSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of DealSummary  ***********************/
	class DealSummaryImpl extends DealIdentifier.DealIdentifierImpl implements DealSummary {
		private final DealRolesModel dealRolesModel;
		private final Date creditAgreementDate;
		private final Currency currency;
		private final DealSummarySequence dealSummarySequence;
		
		protected DealSummaryImpl(DealSummary.DealSummaryBuilder builder) {
			super(builder);
			this.dealRolesModel = ofNullable(builder.getDealRolesModel()).map(f->f.build()).orElse(null);
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.dealSummarySequence = ofNullable(builder.getDealSummarySequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealRolesModel")
		public DealRolesModel getDealRolesModel() {
			return dealRolesModel;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("dealSummarySequence")
		public DealSummarySequence getDealSummarySequence() {
			return dealSummarySequence;
		}
		
		@Override
		public DealSummary build() {
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder toBuilder() {
			DealSummary.DealSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealSummary.DealSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDealRolesModel()).ifPresent(builder::setDealRolesModel);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDealSummarySequence()).ifPresent(builder::setDealSummarySequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealSummary _that = getType().cast(o);
		
			if (!Objects.equals(dealRolesModel, _that.getDealRolesModel())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(dealSummarySequence, _that.getDealSummarySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealRolesModel != null ? dealRolesModel.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (dealSummarySequence != null ? dealSummarySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummary {" +
				"dealRolesModel=" + this.dealRolesModel + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"currency=" + this.currency + ", " +
				"dealSummarySequence=" + this.dealSummarySequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealSummary  ***********************/
	class DealSummaryBuilderImpl extends DealIdentifier.DealIdentifierBuilderImpl  implements DealSummary.DealSummaryBuilder {
	
		protected DealRolesModel.DealRolesModelBuilder dealRolesModel;
		protected Date creditAgreementDate;
		protected Currency.CurrencyBuilder currency;
		protected DealSummarySequence.DealSummarySequenceBuilder dealSummarySequence;
	
		public DealSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dealRolesModel")
		public DealRolesModel.DealRolesModelBuilder getDealRolesModel() {
			return dealRolesModel;
		}
		
		@Override
		public DealRolesModel.DealRolesModelBuilder getOrCreateDealRolesModel() {
			DealRolesModel.DealRolesModelBuilder result;
			if (dealRolesModel!=null) {
				result = dealRolesModel;
			}
			else {
				result = dealRolesModel = DealRolesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealSummarySequence")
		public DealSummarySequence.DealSummarySequenceBuilder getDealSummarySequence() {
			return dealSummarySequence;
		}
		
		@Override
		public DealSummarySequence.DealSummarySequenceBuilder getOrCreateDealSummarySequence() {
			DealSummarySequence.DealSummarySequenceBuilder result;
			if (dealSummarySequence!=null) {
				result = dealSummarySequence;
			}
			else {
				result = dealSummarySequence = DealSummarySequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public DealSummary.DealSummaryBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public DealSummary.DealSummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public DealSummary.DealSummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public DealSummary.DealSummaryBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("dealRolesModel")
		public DealSummary.DealSummaryBuilder setDealRolesModel(DealRolesModel dealRolesModel) {
			this.dealRolesModel = dealRolesModel==null?null:dealRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditAgreementDate")
		public DealSummary.DealSummaryBuilder setCreditAgreementDate(Date creditAgreementDate) {
			this.creditAgreementDate = creditAgreementDate==null?null:creditAgreementDate;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public DealSummary.DealSummaryBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealSummarySequence")
		public DealSummary.DealSummaryBuilder setDealSummarySequence(DealSummarySequence dealSummarySequence) {
			this.dealSummarySequence = dealSummarySequence==null?null:dealSummarySequence.toBuilder();
			return this;
		}
		
		@Override
		public DealSummary build() {
			return new DealSummary.DealSummaryImpl(this);
		}
		
		@Override
		public DealSummary.DealSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummary.DealSummaryBuilder prune() {
			super.prune();
			if (dealRolesModel!=null && !dealRolesModel.prune().hasData()) dealRolesModel = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (dealSummarySequence!=null && !dealSummarySequence.prune().hasData()) dealSummarySequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDealRolesModel()!=null && getDealRolesModel().hasData()) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getDealSummarySequence()!=null && getDealSummarySequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummary.DealSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DealSummary.DealSummaryBuilder o = (DealSummary.DealSummaryBuilder) other;
			
			merger.mergeRosetta(getDealRolesModel(), o.getDealRolesModel(), this::setDealRolesModel);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getDealSummarySequence(), o.getDealSummarySequence(), this::setDealSummarySequence);
			
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealSummary _that = getType().cast(o);
		
			if (!Objects.equals(dealRolesModel, _that.getDealRolesModel())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(dealSummarySequence, _that.getDealSummarySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealRolesModel != null ? dealRolesModel.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (dealSummarySequence != null ? dealSummarySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummaryBuilder {" +
				"dealRolesModel=" + this.dealRolesModel + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"currency=" + this.currency + ", " +
				"dealSummarySequence=" + this.dealSummarySequence +
			'}' + " " + super.toString();
		}
	}
}
