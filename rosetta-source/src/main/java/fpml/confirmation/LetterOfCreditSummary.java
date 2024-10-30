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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LcType;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.LetterOfCreditSummary;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryBuilder;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.LetterOfCreditSummaryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A short form definition of a letter of credit.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LetterOfCreditSummary", builder=LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LetterOfCreditSummary extends RosettaModelObject {

	LetterOfCreditSummaryMeta metaData = new LetterOfCreditSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier for a letter of credit.
	 */
	List<? extends FacilityContractIdentifier> getIdentifier();
	/**
	 * The letter of credit type for which a fee rate is being provided.
	 */
	LcType get_type();
	/**
	 * Effective date of the letter of credit.
	 */
	Date getEffectiveDate();
	LetterOfCreditRolesModel getLetterOfCreditRolesModel();
	/**
	 * The letter of credit notional amount. The amount is represented at the global and (optionally) at the lender-specific level.
	 */
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	LetterOfCreditSummary build();
	
	LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder();
	
	static LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder() {
		return new LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCreditSummary> getType() {
		return LetterOfCreditSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("_type"), processor, LcType.class, get_type());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("letterOfCreditRolesModel"), processor, LetterOfCreditRolesModel.class, getLetterOfCreditRolesModel());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditSummaryBuilder extends LetterOfCreditSummary, RosettaModelObjectBuilder {
		FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateIdentifier(int _index);
		List<? extends FacilityContractIdentifier.FacilityContractIdentifierBuilder> getIdentifier();
		LcType.LcTypeBuilder getOrCreate_type();
		LcType.LcTypeBuilder get_type();
		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder getOrCreateLetterOfCreditRolesModel();
		LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder getLetterOfCreditRolesModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(FacilityContractIdentifier identifier0);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(FacilityContractIdentifier identifier1, int _idx);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifier2);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifier3);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder set_type(LcType _type);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setEffectiveDate(Date effectiveDate);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setLetterOfCreditRolesModel(LetterOfCreditRolesModel letterOfCreditRolesModel);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("_type"), processor, LcType.LcTypeBuilder.class, get_type());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("letterOfCreditRolesModel"), processor, LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder.class, getLetterOfCreditRolesModel());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		LetterOfCreditSummary.LetterOfCreditSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditSummary  ***********************/
	class LetterOfCreditSummaryImpl implements LetterOfCreditSummary {
		private final List<? extends FacilityContractIdentifier> identifier;
		private final LcType _type;
		private final Date effectiveDate;
		private final LetterOfCreditRolesModel letterOfCreditRolesModel;
		private final MoneyWithParticipantShare amount;
		
		protected LetterOfCreditSummaryImpl(LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.letterOfCreditRolesModel = ofNullable(builder.getLetterOfCreditRolesModel()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		public List<? extends FacilityContractIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LcType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditRolesModel")
		public LetterOfCreditRolesModel getLetterOfCreditRolesModel() {
			return letterOfCreditRolesModel;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public LetterOfCreditSummary build() {
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder() {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getLetterOfCreditRolesModel()).ifPresent(builder::setLetterOfCreditRolesModel);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(letterOfCreditRolesModel, _that.getLetterOfCreditRolesModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditRolesModel != null ? letterOfCreditRolesModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditSummary {" +
				"identifier=" + this.identifier + ", " +
				"_type=" + this._type + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"letterOfCreditRolesModel=" + this.letterOfCreditRolesModel + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of LetterOfCreditSummary  ***********************/
	class LetterOfCreditSummaryBuilderImpl implements LetterOfCreditSummary.LetterOfCreditSummaryBuilder {
	
		protected List<FacilityContractIdentifier.FacilityContractIdentifierBuilder> identifier = new ArrayList<>();
		protected LcType.LcTypeBuilder _type;
		protected Date effectiveDate;
		protected LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder letterOfCreditRolesModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
	
		public LetterOfCreditSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("identifier")
		public List<? extends FacilityContractIdentifier.FacilityContractIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public FacilityContractIdentifier.FacilityContractIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			FacilityContractIdentifier.FacilityContractIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						FacilityContractIdentifier.FacilityContractIdentifierBuilder newIdentifier = FacilityContractIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("_type")
		public LcType.LcTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public LcType.LcTypeBuilder getOrCreate_type() {
			LcType.LcTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = LcType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditRolesModel")
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder getLetterOfCreditRolesModel() {
			return letterOfCreditRolesModel;
		}
		
		@Override
		public LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder getOrCreateLetterOfCreditRolesModel() {
			LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder result;
			if (letterOfCreditRolesModel!=null) {
				result = letterOfCreditRolesModel;
			}
			else {
				result = letterOfCreditRolesModel = LetterOfCreditRolesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(FacilityContractIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(FacilityContractIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers != null) {
				for (FacilityContractIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder set_type(LcType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditRolesModel")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setLetterOfCreditRolesModel(LetterOfCreditRolesModel letterOfCreditRolesModel) {
			this.letterOfCreditRolesModel = letterOfCreditRolesModel==null?null:letterOfCreditRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditSummary build() {
			return new LetterOfCreditSummary.LetterOfCreditSummaryImpl(this);
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<FacilityContractIdentifier.FacilityContractIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (letterOfCreditRolesModel!=null && !letterOfCreditRolesModel.prune().hasData()) letterOfCreditRolesModel = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getLetterOfCreditRolesModel()!=null && getLetterOfCreditRolesModel().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder o = (LetterOfCreditSummary.LetterOfCreditSummaryBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getLetterOfCreditRolesModel(), o.getLetterOfCreditRolesModel(), this::setLetterOfCreditRolesModel);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditSummary _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(letterOfCreditRolesModel, _that.getLetterOfCreditRolesModel())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditRolesModel != null ? letterOfCreditRolesModel.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditSummaryBuilder {" +
				"identifier=" + this.identifier + ", " +
				"_type=" + this._type + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"letterOfCreditRolesModel=" + this.letterOfCreditRolesModel + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}
