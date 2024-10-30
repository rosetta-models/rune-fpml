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
import fpml.confirmation.EvergreenOption;
import fpml.confirmation.LcAutoAdjustEnum;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder;
import fpml.confirmation.LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilderImpl;
import fpml.confirmation.LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.LetterOfCreditFeaturesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes the additional features associated with a letter of credit.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LetterOfCreditFeaturesModel", builder=LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LetterOfCreditFeaturesModel extends RosettaModelObject {

	LetterOfCreditFeaturesModelMeta metaData = new LetterOfCreditFeaturesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An option allowing the borrower to extend the letter of credit tenor.
	 */
	EvergreenOption getEvergreenOption();
	/**
	 * Defines the purpose of a letter of credit.
	 */
	LcAutoAdjustEnum getLcAutoAdjust();
	/**
	 * The letter of credit notional amount. The amount is represented at the global and (optionally) atthe lender-specific level.
	 */
	MoneyWithParticipantShare getMinLcIssuanceFeeAmount();

	/*********************** Build Methods  ***********************/
	LetterOfCreditFeaturesModel build();
	
	LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder toBuilder();
	
	static LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder builder() {
		return new LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditFeaturesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCreditFeaturesModel> getType() {
		return LetterOfCreditFeaturesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("evergreenOption"), processor, EvergreenOption.class, getEvergreenOption());
		processor.processBasic(path.newSubPath("lcAutoAdjust"), LcAutoAdjustEnum.class, getLcAutoAdjust(), this);
		processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.class, getMinLcIssuanceFeeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditFeaturesModelBuilder extends LetterOfCreditFeaturesModel, RosettaModelObjectBuilder {
		EvergreenOption.EvergreenOptionBuilder getOrCreateEvergreenOption();
		EvergreenOption.EvergreenOptionBuilder getEvergreenOption();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount();
		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setEvergreenOption(EvergreenOption evergreenOption);
		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setLcAutoAdjust(LcAutoAdjustEnum lcAutoAdjust);
		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("evergreenOption"), processor, EvergreenOption.EvergreenOptionBuilder.class, getEvergreenOption());
			processor.processBasic(path.newSubPath("lcAutoAdjust"), LcAutoAdjustEnum.class, getLcAutoAdjust(), this);
			processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getMinLcIssuanceFeeAmount());
		}
		

		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditFeaturesModel  ***********************/
	class LetterOfCreditFeaturesModelImpl implements LetterOfCreditFeaturesModel {
		private final EvergreenOption evergreenOption;
		private final LcAutoAdjustEnum lcAutoAdjust;
		private final MoneyWithParticipantShare minLcIssuanceFeeAmount;
		
		protected LetterOfCreditFeaturesModelImpl(LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder builder) {
			this.evergreenOption = ofNullable(builder.getEvergreenOption()).map(f->f.build()).orElse(null);
			this.lcAutoAdjust = builder.getLcAutoAdjust();
			this.minLcIssuanceFeeAmount = ofNullable(builder.getMinLcIssuanceFeeAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("evergreenOption")
		public EvergreenOption getEvergreenOption() {
			return evergreenOption;
		}
		
		@Override
		@RosettaAttribute("lcAutoAdjust")
		public LcAutoAdjustEnum getLcAutoAdjust() {
			return lcAutoAdjust;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public LetterOfCreditFeaturesModel build() {
			return this;
		}
		
		@Override
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder toBuilder() {
			LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder builder) {
			ofNullable(getEvergreenOption()).ifPresent(builder::setEvergreenOption);
			ofNullable(getLcAutoAdjust()).ifPresent(builder::setLcAutoAdjust);
			ofNullable(getMinLcIssuanceFeeAmount()).ifPresent(builder::setMinLcIssuanceFeeAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(evergreenOption, _that.getEvergreenOption())) return false;
			if (!Objects.equals(lcAutoAdjust, _that.getLcAutoAdjust())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (evergreenOption != null ? evergreenOption.hashCode() : 0);
			_result = 31 * _result + (lcAutoAdjust != null ? lcAutoAdjust.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditFeaturesModel {" +
				"evergreenOption=" + this.evergreenOption + ", " +
				"lcAutoAdjust=" + this.lcAutoAdjust + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of LetterOfCreditFeaturesModel  ***********************/
	class LetterOfCreditFeaturesModelBuilderImpl implements LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder {
	
		protected EvergreenOption.EvergreenOptionBuilder evergreenOption;
		protected LcAutoAdjustEnum lcAutoAdjust;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder minLcIssuanceFeeAmount;
	
		public LetterOfCreditFeaturesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("evergreenOption")
		public EvergreenOption.EvergreenOptionBuilder getEvergreenOption() {
			return evergreenOption;
		}
		
		@Override
		public EvergreenOption.EvergreenOptionBuilder getOrCreateEvergreenOption() {
			EvergreenOption.EvergreenOptionBuilder result;
			if (evergreenOption!=null) {
				result = evergreenOption;
			}
			else {
				result = evergreenOption = EvergreenOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcAutoAdjust")
		public LcAutoAdjustEnum getLcAutoAdjust() {
			return lcAutoAdjust;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (minLcIssuanceFeeAmount!=null) {
				result = minLcIssuanceFeeAmount;
			}
			else {
				result = minLcIssuanceFeeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("evergreenOption")
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setEvergreenOption(EvergreenOption evergreenOption) {
			this.evergreenOption = evergreenOption==null?null:evergreenOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcAutoAdjust")
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setLcAutoAdjust(LcAutoAdjustEnum lcAutoAdjust) {
			this.lcAutoAdjust = lcAutoAdjust==null?null:lcAutoAdjust;
			return this;
		}
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount) {
			this.minLcIssuanceFeeAmount = minLcIssuanceFeeAmount==null?null:minLcIssuanceFeeAmount.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditFeaturesModel build() {
			return new LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelImpl(this);
		}
		
		@Override
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder prune() {
			if (evergreenOption!=null && !evergreenOption.prune().hasData()) evergreenOption = null;
			if (minLcIssuanceFeeAmount!=null && !minLcIssuanceFeeAmount.prune().hasData()) minLcIssuanceFeeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEvergreenOption()!=null && getEvergreenOption().hasData()) return true;
			if (getLcAutoAdjust()!=null) return true;
			if (getMinLcIssuanceFeeAmount()!=null && getMinLcIssuanceFeeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder o = (LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder) other;
			
			merger.mergeRosetta(getEvergreenOption(), o.getEvergreenOption(), this::setEvergreenOption);
			merger.mergeRosetta(getMinLcIssuanceFeeAmount(), o.getMinLcIssuanceFeeAmount(), this::setMinLcIssuanceFeeAmount);
			
			merger.mergeBasic(getLcAutoAdjust(), o.getLcAutoAdjust(), this::setLcAutoAdjust);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LetterOfCreditFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(evergreenOption, _that.getEvergreenOption())) return false;
			if (!Objects.equals(lcAutoAdjust, _that.getLcAutoAdjust())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (evergreenOption != null ? evergreenOption.hashCode() : 0);
			_result = 31 * _result + (lcAutoAdjust != null ? lcAutoAdjust.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditFeaturesModelBuilder {" +
				"evergreenOption=" + this.evergreenOption + ", " +
				"lcAutoAdjust=" + this.lcAutoAdjust + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount +
			'}';
		}
	}
}
