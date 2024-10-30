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
import fpml.confirmation.ClearingConfirmed;
import fpml.confirmation.ClearingConfirmed.ClearingConfirmedBuilder;
import fpml.confirmation.ClearingConfirmed.ClearingConfirmedBuilderImpl;
import fpml.confirmation.ClearingConfirmed.ClearingConfirmedImpl;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditLimitInformation;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingConfirmedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that a clearing request has been acted on and as a result a trade has been cleared.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ClearingConfirmed", builder=ClearingConfirmed.ClearingConfirmedBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ClearingConfirmed extends NotificationMessage {

	ClearingConfirmedMeta metaData = new ClearingConfirmedMeta();

	/*********************** Getter Methods  ***********************/
	CompressionModel getCompressionModel();
	PortfolioReferenceModel getPortfolioReferenceModel();
	ClearingResultsModel getClearingResultsModel();
	EventValuationModel getEventValuationModel();
	List<? extends CreditLimitInformation> getCreditLimitInformation();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ClearingConfirmed build();
	
	ClearingConfirmed.ClearingConfirmedBuilder toBuilder();
	
	static ClearingConfirmed.ClearingConfirmedBuilder builder() {
		return new ClearingConfirmed.ClearingConfirmedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingConfirmed> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingConfirmed> getType() {
		return ClearingConfirmed.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("compressionModel"), processor, CompressionModel.class, getCompressionModel());
		processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.class, getPortfolioReferenceModel());
		processRosetta(path.newSubPath("clearingResultsModel"), processor, ClearingResultsModel.class, getClearingResultsModel());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingConfirmedBuilder extends ClearingConfirmed, NotificationMessage.NotificationMessageBuilder {
		CompressionModel.CompressionModelBuilder getOrCreateCompressionModel();
		CompressionModel.CompressionModelBuilder getCompressionModel();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel();
		PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel();
		ClearingResultsModel.ClearingResultsModelBuilder getOrCreateClearingResultsModel();
		ClearingResultsModel.ClearingResultsModelBuilder getClearingResultsModel();
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int _index);
		List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ClearingConfirmed.ClearingConfirmedBuilder setExpectedBuild(Integer expectedBuild);
		ClearingConfirmed.ClearingConfirmedBuilder setActualBuild(Integer actualBuild);
		ClearingConfirmed.ClearingConfirmedBuilder setHeader(NotificationMessageHeader header);
		ClearingConfirmed.ClearingConfirmedBuilder setValidationModel(ValidationModel validationModel);
		ClearingConfirmed.ClearingConfirmedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingConfirmed.ClearingConfirmedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ClearingConfirmed.ClearingConfirmedBuilder setCompressionModel(CompressionModel compressionModel);
		ClearingConfirmed.ClearingConfirmedBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel);
		ClearingConfirmed.ClearingConfirmedBuilder setClearingResultsModel(ClearingResultsModel clearingResultsModel);
		ClearingConfirmed.ClearingConfirmedBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation0);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation1, int _idx);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation2);
		ClearingConfirmed.ClearingConfirmedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation3);
		ClearingConfirmed.ClearingConfirmedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("compressionModel"), processor, CompressionModel.CompressionModelBuilder.class, getCompressionModel());
			processRosetta(path.newSubPath("portfolioReferenceModel"), processor, PortfolioReferenceModel.PortfolioReferenceModelBuilder.class, getPortfolioReferenceModel());
			processRosetta(path.newSubPath("clearingResultsModel"), processor, ClearingResultsModel.ClearingResultsModelBuilder.class, getClearingResultsModel());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ClearingConfirmed.ClearingConfirmedBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingConfirmed  ***********************/
	class ClearingConfirmedImpl extends NotificationMessage.NotificationMessageImpl implements ClearingConfirmed {
		private final CompressionModel compressionModel;
		private final PortfolioReferenceModel portfolioReferenceModel;
		private final ClearingResultsModel clearingResultsModel;
		private final EventValuationModel eventValuationModel;
		private final List<? extends CreditLimitInformation> creditLimitInformation;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ClearingConfirmedImpl(ClearingConfirmed.ClearingConfirmedBuilder builder) {
			super(builder);
			this.compressionModel = ofNullable(builder.getCompressionModel()).map(f->f.build()).orElse(null);
			this.portfolioReferenceModel = ofNullable(builder.getPortfolioReferenceModel()).map(f->f.build()).orElse(null);
			this.clearingResultsModel = ofNullable(builder.getClearingResultsModel()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compressionModel")
		public CompressionModel getCompressionModel() {
			return compressionModel;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		@RosettaAttribute("clearingResultsModel")
		public ClearingResultsModel getClearingResultsModel() {
			return clearingResultsModel;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ClearingConfirmed build() {
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder toBuilder() {
			ClearingConfirmed.ClearingConfirmedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingConfirmed.ClearingConfirmedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCompressionModel()).ifPresent(builder::setCompressionModel);
			ofNullable(getPortfolioReferenceModel()).ifPresent(builder::setPortfolioReferenceModel);
			ofNullable(getClearingResultsModel()).ifPresent(builder::setClearingResultsModel);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingConfirmed _that = getType().cast(o);
		
			if (!Objects.equals(compressionModel, _that.getCompressionModel())) return false;
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(clearingResultsModel, _that.getClearingResultsModel())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compressionModel != null ? compressionModel.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (clearingResultsModel != null ? clearingResultsModel.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingConfirmed {" +
				"compressionModel=" + this.compressionModel + ", " +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"clearingResultsModel=" + this.clearingResultsModel + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingConfirmed  ***********************/
	class ClearingConfirmedBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl  implements ClearingConfirmed.ClearingConfirmedBuilder {
	
		protected CompressionModel.CompressionModelBuilder compressionModel;
		protected PortfolioReferenceModel.PortfolioReferenceModelBuilder portfolioReferenceModel;
		protected ClearingResultsModel.ClearingResultsModelBuilder clearingResultsModel;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected List<CreditLimitInformation.CreditLimitInformationBuilder> creditLimitInformation = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ClearingConfirmedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compressionModel")
		public CompressionModel.CompressionModelBuilder getCompressionModel() {
			return compressionModel;
		}
		
		@Override
		public CompressionModel.CompressionModelBuilder getOrCreateCompressionModel() {
			CompressionModel.CompressionModelBuilder result;
			if (compressionModel!=null) {
				result = compressionModel;
			}
			else {
				result = compressionModel = CompressionModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getPortfolioReferenceModel() {
			return portfolioReferenceModel;
		}
		
		@Override
		public PortfolioReferenceModel.PortfolioReferenceModelBuilder getOrCreatePortfolioReferenceModel() {
			PortfolioReferenceModel.PortfolioReferenceModelBuilder result;
			if (portfolioReferenceModel!=null) {
				result = portfolioReferenceModel;
			}
			else {
				result = portfolioReferenceModel = PortfolioReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingResultsModel")
		public ClearingResultsModel.ClearingResultsModelBuilder getClearingResultsModel() {
			return clearingResultsModel;
		}
		
		@Override
		public ClearingResultsModel.ClearingResultsModelBuilder getOrCreateClearingResultsModel() {
			ClearingResultsModel.ClearingResultsModelBuilder result;
			if (clearingResultsModel!=null) {
				result = clearingResultsModel;
			}
			else {
				result = clearingResultsModel = ClearingResultsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel.EventValuationModelBuilder getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel() {
			EventValuationModel.EventValuationModelBuilder result;
			if (eventValuationModel!=null) {
				result = eventValuationModel;
			}
			else {
				result = eventValuationModel = EventValuationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int _index) {
		
			if (creditLimitInformation==null) {
				this.creditLimitInformation = new ArrayList<>();
			}
			CreditLimitInformation.CreditLimitInformationBuilder result;
			return getIndex(creditLimitInformation, _index, () -> {
						CreditLimitInformation.CreditLimitInformationBuilder newCreditLimitInformation = CreditLimitInformation.builder();
						return newCreditLimitInformation;
					});
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
		public ClearingConfirmed.ClearingConfirmedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingConfirmed.ClearingConfirmedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingConfirmed.ClearingConfirmedBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compressionModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setCompressionModel(CompressionModel compressionModel) {
			this.compressionModel = compressionModel==null?null:compressionModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setPortfolioReferenceModel(PortfolioReferenceModel portfolioReferenceModel) {
			this.portfolioReferenceModel = portfolioReferenceModel==null?null:portfolioReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingResultsModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setClearingResultsModel(ClearingResultsModel clearingResultsModel) {
			this.clearingResultsModel = clearingResultsModel==null?null:clearingResultsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditLimitInformation")
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation) {
			if (creditLimitInformation!=null) this.creditLimitInformation.add(creditLimitInformation.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation, int _idx) {
			getIndex(this.creditLimitInformation, _idx, () -> creditLimitInformation.toBuilder());
			return this;
		}
		@Override 
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations != null) {
				for (CreditLimitInformation toAdd : creditLimitInformations) {
					this.creditLimitInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ClearingConfirmed.ClearingConfirmedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations == null)  {
				this.creditLimitInformation = new ArrayList<>();
			}
			else {
				this.creditLimitInformation = creditLimitInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ClearingConfirmed.ClearingConfirmedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ClearingConfirmed build() {
			return new ClearingConfirmed.ClearingConfirmedImpl(this);
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder prune() {
			super.prune();
			if (compressionModel!=null && !compressionModel.prune().hasData()) compressionModel = null;
			if (portfolioReferenceModel!=null && !portfolioReferenceModel.prune().hasData()) portfolioReferenceModel = null;
			if (clearingResultsModel!=null && !clearingResultsModel.prune().hasData()) clearingResultsModel = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			creditLimitInformation = creditLimitInformation.stream().filter(b->b!=null).<CreditLimitInformation.CreditLimitInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCompressionModel()!=null && getCompressionModel().hasData()) return true;
			if (getPortfolioReferenceModel()!=null && getPortfolioReferenceModel().hasData()) return true;
			if (getClearingResultsModel()!=null && getClearingResultsModel().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingConfirmed.ClearingConfirmedBuilder o = (ClearingConfirmed.ClearingConfirmedBuilder) other;
			
			merger.mergeRosetta(getCompressionModel(), o.getCompressionModel(), this::setCompressionModel);
			merger.mergeRosetta(getPortfolioReferenceModel(), o.getPortfolioReferenceModel(), this::setPortfolioReferenceModel);
			merger.mergeRosetta(getClearingResultsModel(), o.getClearingResultsModel(), this::setClearingResultsModel);
			merger.mergeRosetta(getEventValuationModel(), o.getEventValuationModel(), this::setEventValuationModel);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::getOrCreateCreditLimitInformation);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingConfirmed _that = getType().cast(o);
		
			if (!Objects.equals(compressionModel, _that.getCompressionModel())) return false;
			if (!Objects.equals(portfolioReferenceModel, _that.getPortfolioReferenceModel())) return false;
			if (!Objects.equals(clearingResultsModel, _that.getClearingResultsModel())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compressionModel != null ? compressionModel.hashCode() : 0);
			_result = 31 * _result + (portfolioReferenceModel != null ? portfolioReferenceModel.hashCode() : 0);
			_result = 31 * _result + (clearingResultsModel != null ? clearingResultsModel.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingConfirmedBuilder {" +
				"compressionModel=" + this.compressionModel + ", " +
				"portfolioReferenceModel=" + this.portfolioReferenceModel + ", " +
				"clearingResultsModel=" + this.clearingResultsModel + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
