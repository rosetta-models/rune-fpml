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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Currency;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.EquityEuropeanExercise;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder;
import fpml.confirmation.EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl;
import fpml.confirmation.EquityExerciseValuationSettlement.EquityExerciseValuationSettlementImpl;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PrePayment;
import fpml.confirmation.SettlementPriceDefaultElection;
import fpml.confirmation.SettlementPriceSource;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.EquityExerciseValuationSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures for equity options.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityExerciseValuationSettlement", builder=EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityExerciseValuationSettlement extends RosettaModelObject {

	EquityExerciseValuationSettlementMeta metaData = new EquityExerciseValuationSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the expiration date and time for a European style equity option.
	 */
	EquityEuropeanExercise getEquityEuropeanExercise();
	/**
	 * The parameters for defining the exercise period for an American style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 */
	EquityAmericanExercise getEquityAmericanExercise();
	/**
	 * The parameters for defining the exercise period for an Bermuda style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 */
	EquityBermudaExercise getEquityBermudaExercise();
	EquityExerciseValuationSettlementSequence getEquityExerciseValuationSettlementSequence();
	/**
	 * Prepayment features for Forward.
	 */
	PrePayment getPrePayment();
	/**
	 * The parameters for defining when valuation of the underlying takes place.
	 */
	EquityValuation getEquityValuation();
	/**
	 * Date on which settlement of option premiums will occur.
	 */
	AdjustableOrRelativeDate getSettlementDate();
	/**
	 * The currency in which a cash settlement for non-deliverable forward and non-deliverable options.
	 */
	Currency getSettlementCurrency();
	SettlementPriceSource getSettlementPriceSource();
	/**
	 * How the option will be settled.
	 */
	SettlementTypeEnum getSettlementType();
	AdjustableOrRelativeDate getSettlementMethodElectionDate();
	PartyReference getSettlementMethodElectingPartyReference();
	SettlementPriceDefaultElection getSettlementPriceDefaultElection();

	/*********************** Build Methods  ***********************/
	EquityExerciseValuationSettlement build();
	
	EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder();
	
	static EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder() {
		return new EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityExerciseValuationSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityExerciseValuationSettlement> getType() {
		return EquityExerciseValuationSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("equityEuropeanExercise"), processor, EquityEuropeanExercise.class, getEquityEuropeanExercise());
		processRosetta(path.newSubPath("equityAmericanExercise"), processor, EquityAmericanExercise.class, getEquityAmericanExercise());
		processRosetta(path.newSubPath("equityBermudaExercise"), processor, EquityBermudaExercise.class, getEquityBermudaExercise());
		processRosetta(path.newSubPath("equityExerciseValuationSettlementSequence"), processor, EquityExerciseValuationSettlementSequence.class, getEquityExerciseValuationSettlementSequence());
		processRosetta(path.newSubPath("prePayment"), processor, PrePayment.class, getPrePayment());
		processRosetta(path.newSubPath("equityValuation"), processor, EquityValuation.class, getEquityValuation());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.class, getSettlementPriceSource());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementMethodElectionDate"), processor, AdjustableOrRelativeDate.class, getSettlementMethodElectionDate());
		processRosetta(path.newSubPath("settlementMethodElectingPartyReference"), processor, PartyReference.class, getSettlementMethodElectingPartyReference());
		processRosetta(path.newSubPath("settlementPriceDefaultElection"), processor, SettlementPriceDefaultElection.class, getSettlementPriceDefaultElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityExerciseValuationSettlementBuilder extends EquityExerciseValuationSettlement, RosettaModelObjectBuilder {
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder getOrCreateEquityEuropeanExercise();
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder getEquityEuropeanExercise();
		EquityAmericanExercise.EquityAmericanExerciseBuilder getOrCreateEquityAmericanExercise();
		EquityAmericanExercise.EquityAmericanExerciseBuilder getEquityAmericanExercise();
		EquityBermudaExercise.EquityBermudaExerciseBuilder getOrCreateEquityBermudaExercise();
		EquityBermudaExercise.EquityBermudaExerciseBuilder getEquityBermudaExercise();
		EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder getOrCreateEquityExerciseValuationSettlementSequence();
		EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder getEquityExerciseValuationSettlementSequence();
		PrePayment.PrePaymentBuilder getOrCreatePrePayment();
		PrePayment.PrePaymentBuilder getPrePayment();
		EquityValuation.EquityValuationBuilder getOrCreateEquityValuation();
		EquityValuation.EquityValuationBuilder getEquityValuation();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource();
		SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementMethodElectionDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementMethodElectionDate();
		PartyReference.PartyReferenceBuilder getOrCreateSettlementMethodElectingPartyReference();
		PartyReference.PartyReferenceBuilder getSettlementMethodElectingPartyReference();
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getOrCreateSettlementPriceDefaultElection();
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getSettlementPriceDefaultElection();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityEuropeanExercise(EquityEuropeanExercise equityEuropeanExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityAmericanExercise(EquityAmericanExercise equityAmericanExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityBermudaExercise(EquityBermudaExercise equityBermudaExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityExerciseValuationSettlementSequence(EquityExerciseValuationSettlementSequence equityExerciseValuationSettlementSequence);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setPrePayment(PrePayment prePayment);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityValuation(EquityValuation equityValuation);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementCurrency(Currency settlementCurrency);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceSource(SettlementPriceSource settlementPriceSource);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementType(SettlementTypeEnum settlementType);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectionDate(AdjustableOrRelativeDate settlementMethodElectionDate);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectingPartyReference(PartyReference settlementMethodElectingPartyReference);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceDefaultElection(SettlementPriceDefaultElection settlementPriceDefaultElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("equityEuropeanExercise"), processor, EquityEuropeanExercise.EquityEuropeanExerciseBuilder.class, getEquityEuropeanExercise());
			processRosetta(path.newSubPath("equityAmericanExercise"), processor, EquityAmericanExercise.EquityAmericanExerciseBuilder.class, getEquityAmericanExercise());
			processRosetta(path.newSubPath("equityBermudaExercise"), processor, EquityBermudaExercise.EquityBermudaExerciseBuilder.class, getEquityBermudaExercise());
			processRosetta(path.newSubPath("equityExerciseValuationSettlementSequence"), processor, EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder.class, getEquityExerciseValuationSettlementSequence());
			processRosetta(path.newSubPath("prePayment"), processor, PrePayment.PrePaymentBuilder.class, getPrePayment());
			processRosetta(path.newSubPath("equityValuation"), processor, EquityValuation.EquityValuationBuilder.class, getEquityValuation());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.SettlementPriceSourceBuilder.class, getSettlementPriceSource());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementMethodElectionDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementMethodElectionDate());
			processRosetta(path.newSubPath("settlementMethodElectingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSettlementMethodElectingPartyReference());
			processRosetta(path.newSubPath("settlementPriceDefaultElection"), processor, SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder.class, getSettlementPriceDefaultElection());
		}
		

		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of EquityExerciseValuationSettlement  ***********************/
	class EquityExerciseValuationSettlementImpl implements EquityExerciseValuationSettlement {
		private final EquityEuropeanExercise equityEuropeanExercise;
		private final EquityAmericanExercise equityAmericanExercise;
		private final EquityBermudaExercise equityBermudaExercise;
		private final EquityExerciseValuationSettlementSequence equityExerciseValuationSettlementSequence;
		private final PrePayment prePayment;
		private final EquityValuation equityValuation;
		private final AdjustableOrRelativeDate settlementDate;
		private final Currency settlementCurrency;
		private final SettlementPriceSource settlementPriceSource;
		private final SettlementTypeEnum settlementType;
		private final AdjustableOrRelativeDate settlementMethodElectionDate;
		private final PartyReference settlementMethodElectingPartyReference;
		private final SettlementPriceDefaultElection settlementPriceDefaultElection;
		
		protected EquityExerciseValuationSettlementImpl(EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder) {
			this.equityEuropeanExercise = ofNullable(builder.getEquityEuropeanExercise()).map(f->f.build()).orElse(null);
			this.equityAmericanExercise = ofNullable(builder.getEquityAmericanExercise()).map(f->f.build()).orElse(null);
			this.equityBermudaExercise = ofNullable(builder.getEquityBermudaExercise()).map(f->f.build()).orElse(null);
			this.equityExerciseValuationSettlementSequence = ofNullable(builder.getEquityExerciseValuationSettlementSequence()).map(f->f.build()).orElse(null);
			this.prePayment = ofNullable(builder.getPrePayment()).map(f->f.build()).orElse(null);
			this.equityValuation = ofNullable(builder.getEquityValuation()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementPriceSource = ofNullable(builder.getSettlementPriceSource()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.settlementMethodElectionDate = ofNullable(builder.getSettlementMethodElectionDate()).map(f->f.build()).orElse(null);
			this.settlementMethodElectingPartyReference = ofNullable(builder.getSettlementMethodElectingPartyReference()).map(f->f.build()).orElse(null);
			this.settlementPriceDefaultElection = ofNullable(builder.getSettlementPriceDefaultElection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityEuropeanExercise")
		public EquityEuropeanExercise getEquityEuropeanExercise() {
			return equityEuropeanExercise;
		}
		
		@Override
		@RosettaAttribute("equityAmericanExercise")
		public EquityAmericanExercise getEquityAmericanExercise() {
			return equityAmericanExercise;
		}
		
		@Override
		@RosettaAttribute("equityBermudaExercise")
		public EquityBermudaExercise getEquityBermudaExercise() {
			return equityBermudaExercise;
		}
		
		@Override
		@RosettaAttribute("equityExerciseValuationSettlementSequence")
		public EquityExerciseValuationSettlementSequence getEquityExerciseValuationSettlementSequence() {
			return equityExerciseValuationSettlementSequence;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		public PrePayment getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("equityValuation")
		public EquityValuation getEquityValuation() {
			return equityValuation;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		public SettlementPriceSource getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectionDate")
		public AdjustableOrRelativeDate getSettlementMethodElectionDate() {
			return settlementMethodElectionDate;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectingPartyReference")
		public PartyReference getSettlementMethodElectingPartyReference() {
			return settlementMethodElectingPartyReference;
		}
		
		@Override
		@RosettaAttribute("settlementPriceDefaultElection")
		public SettlementPriceDefaultElection getSettlementPriceDefaultElection() {
			return settlementPriceDefaultElection;
		}
		
		@Override
		public EquityExerciseValuationSettlement build() {
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder) {
			ofNullable(getEquityEuropeanExercise()).ifPresent(builder::setEquityEuropeanExercise);
			ofNullable(getEquityAmericanExercise()).ifPresent(builder::setEquityAmericanExercise);
			ofNullable(getEquityBermudaExercise()).ifPresent(builder::setEquityBermudaExercise);
			ofNullable(getEquityExerciseValuationSettlementSequence()).ifPresent(builder::setEquityExerciseValuationSettlementSequence);
			ofNullable(getPrePayment()).ifPresent(builder::setPrePayment);
			ofNullable(getEquityValuation()).ifPresent(builder::setEquityValuation);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementPriceSource()).ifPresent(builder::setSettlementPriceSource);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementMethodElectionDate()).ifPresent(builder::setSettlementMethodElectionDate);
			ofNullable(getSettlementMethodElectingPartyReference()).ifPresent(builder::setSettlementMethodElectingPartyReference);
			ofNullable(getSettlementPriceDefaultElection()).ifPresent(builder::setSettlementPriceDefaultElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(equityEuropeanExercise, _that.getEquityEuropeanExercise())) return false;
			if (!Objects.equals(equityAmericanExercise, _that.getEquityAmericanExercise())) return false;
			if (!Objects.equals(equityBermudaExercise, _that.getEquityBermudaExercise())) return false;
			if (!Objects.equals(equityExerciseValuationSettlementSequence, _that.getEquityExerciseValuationSettlementSequence())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(equityValuation, _that.getEquityValuation())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementMethodElectionDate, _that.getSettlementMethodElectionDate())) return false;
			if (!Objects.equals(settlementMethodElectingPartyReference, _that.getSettlementMethodElectingPartyReference())) return false;
			if (!Objects.equals(settlementPriceDefaultElection, _that.getSettlementPriceDefaultElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityEuropeanExercise != null ? equityEuropeanExercise.hashCode() : 0);
			_result = 31 * _result + (equityAmericanExercise != null ? equityAmericanExercise.hashCode() : 0);
			_result = 31 * _result + (equityBermudaExercise != null ? equityBermudaExercise.hashCode() : 0);
			_result = 31 * _result + (equityExerciseValuationSettlementSequence != null ? equityExerciseValuationSettlementSequence.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (equityValuation != null ? equityValuation.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectionDate != null ? settlementMethodElectionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectingPartyReference != null ? settlementMethodElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElection != null ? settlementPriceDefaultElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlement {" +
				"equityEuropeanExercise=" + this.equityEuropeanExercise + ", " +
				"equityAmericanExercise=" + this.equityAmericanExercise + ", " +
				"equityBermudaExercise=" + this.equityBermudaExercise + ", " +
				"equityExerciseValuationSettlementSequence=" + this.equityExerciseValuationSettlementSequence + ", " +
				"prePayment=" + this.prePayment + ", " +
				"equityValuation=" + this.equityValuation + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementMethodElectionDate=" + this.settlementMethodElectionDate + ", " +
				"settlementMethodElectingPartyReference=" + this.settlementMethodElectingPartyReference + ", " +
				"settlementPriceDefaultElection=" + this.settlementPriceDefaultElection +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityExerciseValuationSettlement  ***********************/
	class EquityExerciseValuationSettlementBuilderImpl implements EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder {
	
		protected EquityEuropeanExercise.EquityEuropeanExerciseBuilder equityEuropeanExercise;
		protected EquityAmericanExercise.EquityAmericanExerciseBuilder equityAmericanExercise;
		protected EquityBermudaExercise.EquityBermudaExerciseBuilder equityBermudaExercise;
		protected EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder equityExerciseValuationSettlementSequence;
		protected PrePayment.PrePaymentBuilder prePayment;
		protected EquityValuation.EquityValuationBuilder equityValuation;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		protected Currency.CurrencyBuilder settlementCurrency;
		protected SettlementPriceSource.SettlementPriceSourceBuilder settlementPriceSource;
		protected SettlementTypeEnum settlementType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementMethodElectionDate;
		protected PartyReference.PartyReferenceBuilder settlementMethodElectingPartyReference;
		protected SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder settlementPriceDefaultElection;
	
		public EquityExerciseValuationSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("equityEuropeanExercise")
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder getEquityEuropeanExercise() {
			return equityEuropeanExercise;
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder getOrCreateEquityEuropeanExercise() {
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder result;
			if (equityEuropeanExercise!=null) {
				result = equityEuropeanExercise;
			}
			else {
				result = equityEuropeanExercise = EquityEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityAmericanExercise")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder getEquityAmericanExercise() {
			return equityAmericanExercise;
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder getOrCreateEquityAmericanExercise() {
			EquityAmericanExercise.EquityAmericanExerciseBuilder result;
			if (equityAmericanExercise!=null) {
				result = equityAmericanExercise;
			}
			else {
				result = equityAmericanExercise = EquityAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityBermudaExercise")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder getEquityBermudaExercise() {
			return equityBermudaExercise;
		}
		
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder getOrCreateEquityBermudaExercise() {
			EquityBermudaExercise.EquityBermudaExerciseBuilder result;
			if (equityBermudaExercise!=null) {
				result = equityBermudaExercise;
			}
			else {
				result = equityBermudaExercise = EquityBermudaExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExerciseValuationSettlementSequence")
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder getEquityExerciseValuationSettlementSequence() {
			return equityExerciseValuationSettlementSequence;
		}
		
		@Override
		public EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder getOrCreateEquityExerciseValuationSettlementSequence() {
			EquityExerciseValuationSettlementSequence.EquityExerciseValuationSettlementSequenceBuilder result;
			if (equityExerciseValuationSettlementSequence!=null) {
				result = equityExerciseValuationSettlementSequence;
			}
			else {
				result = equityExerciseValuationSettlementSequence = EquityExerciseValuationSettlementSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		public PrePayment.PrePaymentBuilder getPrePayment() {
			return prePayment;
		}
		
		@Override
		public PrePayment.PrePaymentBuilder getOrCreatePrePayment() {
			PrePayment.PrePaymentBuilder result;
			if (prePayment!=null) {
				result = prePayment;
			}
			else {
				result = prePayment = PrePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityValuation")
		public EquityValuation.EquityValuationBuilder getEquityValuation() {
			return equityValuation;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateEquityValuation() {
			EquityValuation.EquityValuationBuilder result;
			if (equityValuation!=null) {
				result = equityValuation;
			}
			else {
				result = equityValuation = EquityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		public SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource() {
			SettlementPriceSource.SettlementPriceSourceBuilder result;
			if (settlementPriceSource!=null) {
				result = settlementPriceSource;
			}
			else {
				result = settlementPriceSource = SettlementPriceSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectionDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementMethodElectionDate() {
			return settlementMethodElectionDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementMethodElectionDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementMethodElectionDate!=null) {
				result = settlementMethodElectionDate;
			}
			else {
				result = settlementMethodElectionDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectingPartyReference")
		public PartyReference.PartyReferenceBuilder getSettlementMethodElectingPartyReference() {
			return settlementMethodElectingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSettlementMethodElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (settlementMethodElectingPartyReference!=null) {
				result = settlementMethodElectingPartyReference;
			}
			else {
				result = settlementMethodElectingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPriceDefaultElection")
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getSettlementPriceDefaultElection() {
			return settlementPriceDefaultElection;
		}
		
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getOrCreateSettlementPriceDefaultElection() {
			SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder result;
			if (settlementPriceDefaultElection!=null) {
				result = settlementPriceDefaultElection;
			}
			else {
				result = settlementPriceDefaultElection = SettlementPriceDefaultElection.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityEuropeanExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityEuropeanExercise(EquityEuropeanExercise equityEuropeanExercise) {
			this.equityEuropeanExercise = equityEuropeanExercise==null?null:equityEuropeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityAmericanExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityAmericanExercise(EquityAmericanExercise equityAmericanExercise) {
			this.equityAmericanExercise = equityAmericanExercise==null?null:equityAmericanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityBermudaExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityBermudaExercise(EquityBermudaExercise equityBermudaExercise) {
			this.equityBermudaExercise = equityBermudaExercise==null?null:equityBermudaExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExerciseValuationSettlementSequence")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityExerciseValuationSettlementSequence(EquityExerciseValuationSettlementSequence equityExerciseValuationSettlementSequence) {
			this.equityExerciseValuationSettlementSequence = equityExerciseValuationSettlementSequence==null?null:equityExerciseValuationSettlementSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("prePayment")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setPrePayment(PrePayment prePayment) {
			this.prePayment = prePayment==null?null:prePayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityValuation")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityValuation(EquityValuation equityValuation) {
			this.equityValuation = equityValuation==null?null:equityValuation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementCurrency(Currency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPriceSource")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceSource(SettlementPriceSource settlementPriceSource) {
			this.settlementPriceSource = settlementPriceSource==null?null:settlementPriceSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		@RosettaAttribute("settlementMethodElectionDate")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectionDate(AdjustableOrRelativeDate settlementMethodElectionDate) {
			this.settlementMethodElectionDate = settlementMethodElectionDate==null?null:settlementMethodElectionDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementMethodElectingPartyReference")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectingPartyReference(PartyReference settlementMethodElectingPartyReference) {
			this.settlementMethodElectingPartyReference = settlementMethodElectingPartyReference==null?null:settlementMethodElectingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPriceDefaultElection")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceDefaultElection(SettlementPriceDefaultElection settlementPriceDefaultElection) {
			this.settlementPriceDefaultElection = settlementPriceDefaultElection==null?null:settlementPriceDefaultElection.toBuilder();
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlement build() {
			return new EquityExerciseValuationSettlement.EquityExerciseValuationSettlementImpl(this);
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder prune() {
			if (equityEuropeanExercise!=null && !equityEuropeanExercise.prune().hasData()) equityEuropeanExercise = null;
			if (equityAmericanExercise!=null && !equityAmericanExercise.prune().hasData()) equityAmericanExercise = null;
			if (equityBermudaExercise!=null && !equityBermudaExercise.prune().hasData()) equityBermudaExercise = null;
			if (equityExerciseValuationSettlementSequence!=null && !equityExerciseValuationSettlementSequence.prune().hasData()) equityExerciseValuationSettlementSequence = null;
			if (prePayment!=null && !prePayment.prune().hasData()) prePayment = null;
			if (equityValuation!=null && !equityValuation.prune().hasData()) equityValuation = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (settlementPriceSource!=null && !settlementPriceSource.prune().hasData()) settlementPriceSource = null;
			if (settlementMethodElectionDate!=null && !settlementMethodElectionDate.prune().hasData()) settlementMethodElectionDate = null;
			if (settlementMethodElectingPartyReference!=null && !settlementMethodElectingPartyReference.prune().hasData()) settlementMethodElectingPartyReference = null;
			if (settlementPriceDefaultElection!=null && !settlementPriceDefaultElection.prune().hasData()) settlementPriceDefaultElection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEquityEuropeanExercise()!=null && getEquityEuropeanExercise().hasData()) return true;
			if (getEquityAmericanExercise()!=null && getEquityAmericanExercise().hasData()) return true;
			if (getEquityBermudaExercise()!=null && getEquityBermudaExercise().hasData()) return true;
			if (getEquityExerciseValuationSettlementSequence()!=null && getEquityExerciseValuationSettlementSequence().hasData()) return true;
			if (getPrePayment()!=null && getPrePayment().hasData()) return true;
			if (getEquityValuation()!=null && getEquityValuation().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getSettlementPriceSource()!=null && getSettlementPriceSource().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementMethodElectionDate()!=null && getSettlementMethodElectionDate().hasData()) return true;
			if (getSettlementMethodElectingPartyReference()!=null && getSettlementMethodElectingPartyReference().hasData()) return true;
			if (getSettlementPriceDefaultElection()!=null && getSettlementPriceDefaultElection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder o = (EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder) other;
			
			merger.mergeRosetta(getEquityEuropeanExercise(), o.getEquityEuropeanExercise(), this::setEquityEuropeanExercise);
			merger.mergeRosetta(getEquityAmericanExercise(), o.getEquityAmericanExercise(), this::setEquityAmericanExercise);
			merger.mergeRosetta(getEquityBermudaExercise(), o.getEquityBermudaExercise(), this::setEquityBermudaExercise);
			merger.mergeRosetta(getEquityExerciseValuationSettlementSequence(), o.getEquityExerciseValuationSettlementSequence(), this::setEquityExerciseValuationSettlementSequence);
			merger.mergeRosetta(getPrePayment(), o.getPrePayment(), this::setPrePayment);
			merger.mergeRosetta(getEquityValuation(), o.getEquityValuation(), this::setEquityValuation);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getSettlementPriceSource(), o.getSettlementPriceSource(), this::setSettlementPriceSource);
			merger.mergeRosetta(getSettlementMethodElectionDate(), o.getSettlementMethodElectionDate(), this::setSettlementMethodElectionDate);
			merger.mergeRosetta(getSettlementMethodElectingPartyReference(), o.getSettlementMethodElectingPartyReference(), this::setSettlementMethodElectingPartyReference);
			merger.mergeRosetta(getSettlementPriceDefaultElection(), o.getSettlementPriceDefaultElection(), this::setSettlementPriceDefaultElection);
			
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(equityEuropeanExercise, _that.getEquityEuropeanExercise())) return false;
			if (!Objects.equals(equityAmericanExercise, _that.getEquityAmericanExercise())) return false;
			if (!Objects.equals(equityBermudaExercise, _that.getEquityBermudaExercise())) return false;
			if (!Objects.equals(equityExerciseValuationSettlementSequence, _that.getEquityExerciseValuationSettlementSequence())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(equityValuation, _that.getEquityValuation())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementMethodElectionDate, _that.getSettlementMethodElectionDate())) return false;
			if (!Objects.equals(settlementMethodElectingPartyReference, _that.getSettlementMethodElectingPartyReference())) return false;
			if (!Objects.equals(settlementPriceDefaultElection, _that.getSettlementPriceDefaultElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityEuropeanExercise != null ? equityEuropeanExercise.hashCode() : 0);
			_result = 31 * _result + (equityAmericanExercise != null ? equityAmericanExercise.hashCode() : 0);
			_result = 31 * _result + (equityBermudaExercise != null ? equityBermudaExercise.hashCode() : 0);
			_result = 31 * _result + (equityExerciseValuationSettlementSequence != null ? equityExerciseValuationSettlementSequence.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (equityValuation != null ? equityValuation.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectionDate != null ? settlementMethodElectionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectingPartyReference != null ? settlementMethodElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElection != null ? settlementPriceDefaultElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlementBuilder {" +
				"equityEuropeanExercise=" + this.equityEuropeanExercise + ", " +
				"equityAmericanExercise=" + this.equityAmericanExercise + ", " +
				"equityBermudaExercise=" + this.equityBermudaExercise + ", " +
				"equityExerciseValuationSettlementSequence=" + this.equityExerciseValuationSettlementSequence + ", " +
				"prePayment=" + this.prePayment + ", " +
				"equityValuation=" + this.equityValuation + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementMethodElectionDate=" + this.settlementMethodElectionDate + ", " +
				"settlementMethodElectingPartyReference=" + this.settlementMethodElectingPartyReference + ", " +
				"settlementPriceDefaultElection=" + this.settlementPriceDefaultElection +
			'}';
		}
	}
}
