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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.MaturityNotification;
import fpml.confirmation.MaturityNotification.MaturityNotificationBuilder;
import fpml.confirmation.MaturityNotification.MaturityNotificationBuilderImpl;
import fpml.confirmation.MaturityNotification.MaturityNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExpiryBase;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradeMaturity;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.MaturityNotificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message used to notify another party that a trade has matured. This can be used to report, for example, that a swap has passed its final payment and can be removed, or that an option has expired without being executed.
 * @version ${project.version}
 */
@RosettaDataType(value="MaturityNotification", builder=MaturityNotification.MaturityNotificationBuilderImpl.class, version="${project.version}")
public interface MaturityNotification extends CorrectableRequestMessage {

	MaturityNotificationMeta metaData = new MaturityNotificationMeta();

	/*********************** Getter Methods  ***********************/
	OptionExpiryBase getOptionExpiry();
	TradeMaturity getTradeMaturity();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	MaturityNotification build();
	
	MaturityNotification.MaturityNotificationBuilder toBuilder();
	
	static MaturityNotification.MaturityNotificationBuilder builder() {
		return new MaturityNotification.MaturityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MaturityNotification> getType() {
		return MaturityNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiryBase.class, getOptionExpiry());
		processRosetta(path.newSubPath("tradeMaturity"), processor, TradeMaturity.class, getTradeMaturity());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MaturityNotificationBuilder extends MaturityNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		OptionExpiryBase.OptionExpiryBaseBuilder getOrCreateOptionExpiry();
		OptionExpiryBase.OptionExpiryBaseBuilder getOptionExpiry();
		TradeMaturity.TradeMaturityBuilder getOrCreateTradeMaturity();
		TradeMaturity.TradeMaturityBuilder getTradeMaturity();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		MaturityNotification.MaturityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		MaturityNotification.MaturityNotificationBuilder setActualBuild(Integer actualBuild);
		MaturityNotification.MaturityNotificationBuilder setHeader(RequestMessageHeader header);
		MaturityNotification.MaturityNotificationBuilder setValidationModel(ValidationModel validationModel);
		MaturityNotification.MaturityNotificationBuilder setIsCorrection(Boolean isCorrection);
		MaturityNotification.MaturityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		MaturityNotification.MaturityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		MaturityNotification.MaturityNotificationBuilder setOptionExpiry(OptionExpiryBase optionExpiry);
		MaturityNotification.MaturityNotificationBuilder setTradeMaturity(TradeMaturity tradeMaturity);
		MaturityNotification.MaturityNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiryBase.OptionExpiryBaseBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("tradeMaturity"), processor, TradeMaturity.TradeMaturityBuilder.class, getTradeMaturity());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		MaturityNotification.MaturityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityNotification  ***********************/
	class MaturityNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements MaturityNotification {
		private final OptionExpiryBase optionExpiry;
		private final TradeMaturity tradeMaturity;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected MaturityNotificationImpl(MaturityNotification.MaturityNotificationBuilder builder) {
			super(builder);
			this.optionExpiry = ofNullable(builder.getOptionExpiry()).map(f->f.build()).orElse(null);
			this.tradeMaturity = ofNullable(builder.getTradeMaturity()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		public OptionExpiryBase getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		@RosettaAttribute("tradeMaturity")
		public TradeMaturity getTradeMaturity() {
			return tradeMaturity;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public MaturityNotification build() {
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder toBuilder() {
			MaturityNotification.MaturityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityNotification.MaturityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionExpiry()).ifPresent(builder::setOptionExpiry);
			ofNullable(getTradeMaturity()).ifPresent(builder::setTradeMaturity);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MaturityNotification _that = getType().cast(o);
		
			if (!Objects.equals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(tradeMaturity, _that.getTradeMaturity())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (tradeMaturity != null ? tradeMaturity.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityNotification {" +
				"optionExpiry=" + this.optionExpiry + ", " +
				"tradeMaturity=" + this.tradeMaturity + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityNotification  ***********************/
	class MaturityNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements MaturityNotification.MaturityNotificationBuilder {
	
		protected OptionExpiryBase.OptionExpiryBaseBuilder optionExpiry;
		protected TradeMaturity.TradeMaturityBuilder tradeMaturity;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public MaturityNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionExpiry")
		public OptionExpiryBase.OptionExpiryBaseBuilder getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder getOrCreateOptionExpiry() {
			OptionExpiryBase.OptionExpiryBaseBuilder result;
			if (optionExpiry!=null) {
				result = optionExpiry;
			}
			else {
				result = optionExpiry = OptionExpiryBase.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeMaturity")
		public TradeMaturity.TradeMaturityBuilder getTradeMaturity() {
			return tradeMaturity;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder getOrCreateTradeMaturity() {
			TradeMaturity.TradeMaturityBuilder result;
			if (tradeMaturity!=null) {
				result = tradeMaturity;
			}
			else {
				result = tradeMaturity = TradeMaturity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public MaturityNotification.MaturityNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public MaturityNotification.MaturityNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public MaturityNotification.MaturityNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public MaturityNotification.MaturityNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public MaturityNotification.MaturityNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public MaturityNotification.MaturityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public MaturityNotification.MaturityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExpiry")
		public MaturityNotification.MaturityNotificationBuilder setOptionExpiry(OptionExpiryBase optionExpiry) {
			this.optionExpiry = optionExpiry==null?null:optionExpiry.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeMaturity")
		public MaturityNotification.MaturityNotificationBuilder setTradeMaturity(TradeMaturity tradeMaturity) {
			this.tradeMaturity = tradeMaturity==null?null:tradeMaturity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public MaturityNotification.MaturityNotificationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public MaturityNotification build() {
			return new MaturityNotification.MaturityNotificationImpl(this);
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityNotification.MaturityNotificationBuilder prune() {
			super.prune();
			if (optionExpiry!=null && !optionExpiry.prune().hasData()) optionExpiry = null;
			if (tradeMaturity!=null && !tradeMaturity.prune().hasData()) tradeMaturity = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionExpiry()!=null && getOptionExpiry().hasData()) return true;
			if (getTradeMaturity()!=null && getTradeMaturity().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityNotification.MaturityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MaturityNotification.MaturityNotificationBuilder o = (MaturityNotification.MaturityNotificationBuilder) other;
			
			merger.mergeRosetta(getOptionExpiry(), o.getOptionExpiry(), this::setOptionExpiry);
			merger.mergeRosetta(getTradeMaturity(), o.getTradeMaturity(), this::setTradeMaturity);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MaturityNotification _that = getType().cast(o);
		
			if (!Objects.equals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(tradeMaturity, _that.getTradeMaturity())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (tradeMaturity != null ? tradeMaturity.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityNotificationBuilder {" +
				"optionExpiry=" + this.optionExpiry + ", " +
				"tradeMaturity=" + this.tradeMaturity + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
