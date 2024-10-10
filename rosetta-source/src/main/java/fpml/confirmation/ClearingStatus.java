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
import fpml.confirmation.ClearingStatus;
import fpml.confirmation.ClearingStatus.ClearingStatusBuilder;
import fpml.confirmation.ClearingStatus.ClearingStatusBuilderImpl;
import fpml.confirmation.ClearingStatus.ClearingStatusImpl;
import fpml.confirmation.ClearingStatusItem;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message providing the current status of a clearing request.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingStatus", builder=ClearingStatus.ClearingStatusBuilderImpl.class, version="${project.version}")
public interface ClearingStatus extends NotificationMessage {

	ClearingStatusMeta metaData = new ClearingStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the status of the clearing process relating to the identified trade.
	 */
	ClearingStatusItem getClearingStatusItem();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ClearingStatus build();
	
	ClearingStatus.ClearingStatusBuilder toBuilder();
	
	static ClearingStatus.ClearingStatusBuilder builder() {
		return new ClearingStatus.ClearingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingStatus> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingStatus> getType() {
		return ClearingStatus.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("clearingStatusItem"), processor, ClearingStatusItem.class, getClearingStatusItem());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingStatusBuilder extends ClearingStatus, NotificationMessage.NotificationMessageBuilder {
		ClearingStatusItem.ClearingStatusItemBuilder getOrCreateClearingStatusItem();
		ClearingStatusItem.ClearingStatusItemBuilder getClearingStatusItem();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ClearingStatus.ClearingStatusBuilder setExpectedBuild(Integer expectedBuild);
		ClearingStatus.ClearingStatusBuilder setActualBuild(Integer actualBuild);
		ClearingStatus.ClearingStatusBuilder setHeader(NotificationMessageHeader header);
		ClearingStatus.ClearingStatusBuilder setValidationModel(ValidationModel validationModel);
		ClearingStatus.ClearingStatusBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingStatus.ClearingStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ClearingStatus.ClearingStatusBuilder setClearingStatusItem(ClearingStatusItem clearingStatusItem);
		ClearingStatus.ClearingStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("clearingStatusItem"), processor, ClearingStatusItem.ClearingStatusItemBuilder.class, getClearingStatusItem());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ClearingStatus.ClearingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingStatus  ***********************/
	class ClearingStatusImpl extends NotificationMessage.NotificationMessageImpl implements ClearingStatus {
		private final ClearingStatusItem clearingStatusItem;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ClearingStatusImpl(ClearingStatus.ClearingStatusBuilder builder) {
			super(builder);
			this.clearingStatusItem = ofNullable(builder.getClearingStatusItem()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingStatusItem")
		public ClearingStatusItem getClearingStatusItem() {
			return clearingStatusItem;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public ClearingStatus build() {
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder toBuilder() {
			ClearingStatus.ClearingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingStatus.ClearingStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getClearingStatusItem()).ifPresent(builder::setClearingStatusItem);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingStatus _that = getType().cast(o);
		
			if (!Objects.equals(clearingStatusItem, _that.getClearingStatusItem())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingStatusItem != null ? clearingStatusItem.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatus {" +
				"clearingStatusItem=" + this.clearingStatusItem + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingStatus  ***********************/
	class ClearingStatusBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl  implements ClearingStatus.ClearingStatusBuilder {
	
		protected ClearingStatusItem.ClearingStatusItemBuilder clearingStatusItem;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ClearingStatusBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("clearingStatusItem")
		public ClearingStatusItem.ClearingStatusItemBuilder getClearingStatusItem() {
			return clearingStatusItem;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder getOrCreateClearingStatusItem() {
			ClearingStatusItem.ClearingStatusItemBuilder result;
			if (clearingStatusItem!=null) {
				result = clearingStatusItem;
			}
			else {
				result = clearingStatusItem = ClearingStatusItem.builder();
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
		public ClearingStatus.ClearingStatusBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingStatus.ClearingStatusBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingStatus.ClearingStatusBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingStatus.ClearingStatusBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingStatus.ClearingStatusBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ClearingStatus.ClearingStatusBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearingStatusItem")
		public ClearingStatus.ClearingStatusBuilder setClearingStatusItem(ClearingStatusItem clearingStatusItem) {
			this.clearingStatusItem = clearingStatusItem==null?null:clearingStatusItem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ClearingStatus.ClearingStatusBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ClearingStatus build() {
			return new ClearingStatus.ClearingStatusImpl(this);
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatus.ClearingStatusBuilder prune() {
			super.prune();
			if (clearingStatusItem!=null && !clearingStatusItem.prune().hasData()) clearingStatusItem = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getClearingStatusItem()!=null && getClearingStatusItem().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatus.ClearingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingStatus.ClearingStatusBuilder o = (ClearingStatus.ClearingStatusBuilder) other;
			
			merger.mergeRosetta(getClearingStatusItem(), o.getClearingStatusItem(), this::setClearingStatusItem);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingStatus _that = getType().cast(o);
		
			if (!Objects.equals(clearingStatusItem, _that.getClearingStatusItem())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingStatusItem != null ? clearingStatusItem.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusBuilder {" +
				"clearingStatusItem=" + this.clearingStatusItem + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
