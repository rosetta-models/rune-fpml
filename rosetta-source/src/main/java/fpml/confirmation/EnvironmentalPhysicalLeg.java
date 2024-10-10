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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DateOffset;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.confirmation.EnvironmentalPhysicalLeg;
import fpml.confirmation.EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder;
import fpml.confirmation.EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl;
import fpml.confirmation.EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegImpl;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilder;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegBuilderImpl;
import fpml.confirmation.PhysicalSwapLeg.PhysicalSwapLegImpl;
import fpml.confirmation.UnitQuantity;
import fpml.confirmation.meta.EnvironmentalPhysicalLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Physically settled environmental leg.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentalPhysicalLeg", builder=EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl.class, version="${project.version}")
public interface EnvironmentalPhysicalLeg extends PhysicalSwapLeg {

	EnvironmentalPhysicalLegMeta metaData = new EnvironmentalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of allowances, certificates or credit to be transaction in the transaction.
	 */
	UnitQuantity getNumberOfAllowances();
	/**
	 * The specification of the type of allowance or credit.
	 */
	EnvironmentalProduct getEnvironmental();
	/**
	 * Applies to U.S. Emissions Allowance Transactions. Specifies terms which apply in the event of an Abandonment of Scheme event.
	 */
	EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme();
	/**
	 * The date on which allowances are to be delivered as specified in the related Confirmation.
	 */
	AdjustableOrRelativeDate getDeliveryDate();
	DateOffset getPaymentDate();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	/**
	 * Applies to EU Emissions Allowance Transactions. Holds the Failure to Deliver (Alternative Method) election. Used to determine how provisions in Part [7] Page 7 (B) Failure to Deliver Not Remedied are to be applied.
	 */
	Boolean getFailureToDeliverApplicable();
	/**
	 * Applies to EU Emissions Allowance Transactions. Contains a series of parameters controlling Excess Emissions Penalty payments.
	 */
	EEPParameters getEEPParameters();

	/*********************** Build Methods  ***********************/
	EnvironmentalPhysicalLeg build();
	
	EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder();
	
	static EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder() {
		return new EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EnvironmentalPhysicalLeg> getType() {
		return EnvironmentalPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("numberOfAllowances"), processor, UnitQuantity.class, getNumberOfAllowances());
		processRosetta(path.newSubPath("environmental"), processor, EnvironmentalProduct.class, getEnvironmental());
		processor.processBasic(path.newSubPath("abandonmentOfScheme"), EnvironmentalAbandonmentOfSchemeEnum.class, getAbandonmentOfScheme(), this);
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.class, getDeliveryDate());
		processRosetta(path.newSubPath("paymentDate"), processor, DateOffset.class, getPaymentDate());
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processor.processBasic(path.newSubPath("failureToDeliverApplicable"), Boolean.class, getFailureToDeliverApplicable(), this);
		processRosetta(path.newSubPath("eEPParameters"), processor, EEPParameters.class, getEEPParameters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalPhysicalLegBuilder extends EnvironmentalPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		UnitQuantity.UnitQuantityBuilder getOrCreateNumberOfAllowances();
		UnitQuantity.UnitQuantityBuilder getNumberOfAllowances();
		EnvironmentalProduct.EnvironmentalProductBuilder getOrCreateEnvironmental();
		EnvironmentalProduct.EnvironmentalProductBuilder getEnvironmental();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate();
		DateOffset.DateOffsetBuilder getOrCreatePaymentDate();
		DateOffset.DateOffsetBuilder getPaymentDate();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		EEPParameters.EEPParametersBuilder getOrCreateEEPParameters();
		EEPParameters.EEPParametersBuilder getEEPParameters();
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setId(String id);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setNumberOfAllowances(UnitQuantity numberOfAllowances);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEnvironmental(EnvironmentalProduct environmental);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setAbandonmentOfScheme(EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPaymentDate(DateOffset paymentDate);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setFailureToDeliverApplicable(Boolean failureToDeliverApplicable);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEEPParameters(EEPParameters eEPParameters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("numberOfAllowances"), processor, UnitQuantity.UnitQuantityBuilder.class, getNumberOfAllowances());
			processRosetta(path.newSubPath("environmental"), processor, EnvironmentalProduct.EnvironmentalProductBuilder.class, getEnvironmental());
			processor.processBasic(path.newSubPath("abandonmentOfScheme"), EnvironmentalAbandonmentOfSchemeEnum.class, getAbandonmentOfScheme(), this);
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getDeliveryDate());
			processRosetta(path.newSubPath("paymentDate"), processor, DateOffset.DateOffsetBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processor.processBasic(path.newSubPath("failureToDeliverApplicable"), Boolean.class, getFailureToDeliverApplicable(), this);
			processRosetta(path.newSubPath("eEPParameters"), processor, EEPParameters.EEPParametersBuilder.class, getEEPParameters());
		}
		

		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalPhysicalLeg  ***********************/
	class EnvironmentalPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements EnvironmentalPhysicalLeg {
		private final UnitQuantity numberOfAllowances;
		private final EnvironmentalProduct environmental;
		private final EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme;
		private final AdjustableOrRelativeDate deliveryDate;
		private final DateOffset paymentDate;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final Boolean failureToDeliverApplicable;
		private final EEPParameters eEPParameters;
		
		protected EnvironmentalPhysicalLegImpl(EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder) {
			super(builder);
			this.numberOfAllowances = ofNullable(builder.getNumberOfAllowances()).map(f->f.build()).orElse(null);
			this.environmental = ofNullable(builder.getEnvironmental()).map(f->f.build()).orElse(null);
			this.abandonmentOfScheme = builder.getAbandonmentOfScheme();
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.failureToDeliverApplicable = builder.getFailureToDeliverApplicable();
			this.eEPParameters = ofNullable(builder.getEEPParameters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("numberOfAllowances")
		public UnitQuantity getNumberOfAllowances() {
			return numberOfAllowances;
		}
		
		@Override
		@RosettaAttribute("environmental")
		public EnvironmentalProduct getEnvironmental() {
			return environmental;
		}
		
		@Override
		@RosettaAttribute("abandonmentOfScheme")
		public EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme() {
			return abandonmentOfScheme;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableOrRelativeDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public DateOffset getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("failureToDeliverApplicable")
		public Boolean getFailureToDeliverApplicable() {
			return failureToDeliverApplicable;
		}
		
		@Override
		@RosettaAttribute("eEPParameters")
		public EEPParameters getEEPParameters() {
			return eEPParameters;
		}
		
		@Override
		public EnvironmentalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder() {
			EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNumberOfAllowances()).ifPresent(builder::setNumberOfAllowances);
			ofNullable(getEnvironmental()).ifPresent(builder::setEnvironmental);
			ofNullable(getAbandonmentOfScheme()).ifPresent(builder::setAbandonmentOfScheme);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getFailureToDeliverApplicable()).ifPresent(builder::setFailureToDeliverApplicable);
			ofNullable(getEEPParameters()).ifPresent(builder::setEEPParameters);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EnvironmentalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(numberOfAllowances, _that.getNumberOfAllowances())) return false;
			if (!Objects.equals(environmental, _that.getEnvironmental())) return false;
			if (!Objects.equals(abandonmentOfScheme, _that.getAbandonmentOfScheme())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(failureToDeliverApplicable, _that.getFailureToDeliverApplicable())) return false;
			if (!Objects.equals(eEPParameters, _that.getEEPParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfAllowances != null ? numberOfAllowances.hashCode() : 0);
			_result = 31 * _result + (environmental != null ? environmental.hashCode() : 0);
			_result = 31 * _result + (abandonmentOfScheme != null ? abandonmentOfScheme.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (failureToDeliverApplicable != null ? failureToDeliverApplicable.hashCode() : 0);
			_result = 31 * _result + (eEPParameters != null ? eEPParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalPhysicalLeg {" +
				"numberOfAllowances=" + this.numberOfAllowances + ", " +
				"environmental=" + this.environmental + ", " +
				"abandonmentOfScheme=" + this.abandonmentOfScheme + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"failureToDeliverApplicable=" + this.failureToDeliverApplicable + ", " +
				"eEPParameters=" + this.eEPParameters +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EnvironmentalPhysicalLeg  ***********************/
	class EnvironmentalPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl  implements EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder {
	
		protected UnitQuantity.UnitQuantityBuilder numberOfAllowances;
		protected EnvironmentalProduct.EnvironmentalProductBuilder environmental;
		protected EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder deliveryDate;
		protected DateOffset.DateOffsetBuilder paymentDate;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected Boolean failureToDeliverApplicable;
		protected EEPParameters.EEPParametersBuilder eEPParameters;
	
		public EnvironmentalPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfAllowances")
		public UnitQuantity.UnitQuantityBuilder getNumberOfAllowances() {
			return numberOfAllowances;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder getOrCreateNumberOfAllowances() {
			UnitQuantity.UnitQuantityBuilder result;
			if (numberOfAllowances!=null) {
				result = numberOfAllowances;
			}
			else {
				result = numberOfAllowances = UnitQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("environmental")
		public EnvironmentalProduct.EnvironmentalProductBuilder getEnvironmental() {
			return environmental;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder getOrCreateEnvironmental() {
			EnvironmentalProduct.EnvironmentalProductBuilder result;
			if (environmental!=null) {
				result = environmental;
			}
			else {
				result = environmental = EnvironmentalProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("abandonmentOfScheme")
		public EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme() {
			return abandonmentOfScheme;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		public DateOffset.DateOffsetBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreatePaymentDate() {
			DateOffset.DateOffsetBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = DateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("failureToDeliverApplicable")
		public Boolean getFailureToDeliverApplicable() {
			return failureToDeliverApplicable;
		}
		
		@Override
		@RosettaAttribute("eEPParameters")
		public EEPParameters.EEPParametersBuilder getEEPParameters() {
			return eEPParameters;
		}
		
		@Override
		public EEPParameters.EEPParametersBuilder getOrCreateEEPParameters() {
			EEPParameters.EEPParametersBuilder result;
			if (eEPParameters!=null) {
				result = eEPParameters;
			}
			else {
				result = eEPParameters = EEPParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfAllowances")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setNumberOfAllowances(UnitQuantity numberOfAllowances) {
			this.numberOfAllowances = numberOfAllowances==null?null:numberOfAllowances.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("environmental")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEnvironmental(EnvironmentalProduct environmental) {
			this.environmental = environmental==null?null:environmental.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("abandonmentOfScheme")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setAbandonmentOfScheme(EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme) {
			this.abandonmentOfScheme = abandonmentOfScheme==null?null:abandonmentOfScheme;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryDate")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate) {
			this.deliveryDate = deliveryDate==null?null:deliveryDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPaymentDate(DateOffset paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("failureToDeliverApplicable")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setFailureToDeliverApplicable(Boolean failureToDeliverApplicable) {
			this.failureToDeliverApplicable = failureToDeliverApplicable==null?null:failureToDeliverApplicable;
			return this;
		}
		@Override
		@RosettaAttribute("eEPParameters")
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEEPParameters(EEPParameters eEPParameters) {
			this.eEPParameters = eEPParameters==null?null:eEPParameters.toBuilder();
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg build() {
			return new EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegImpl(this);
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder prune() {
			super.prune();
			if (numberOfAllowances!=null && !numberOfAllowances.prune().hasData()) numberOfAllowances = null;
			if (environmental!=null && !environmental.prune().hasData()) environmental = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			if (eEPParameters!=null && !eEPParameters.prune().hasData()) eEPParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNumberOfAllowances()!=null && getNumberOfAllowances().hasData()) return true;
			if (getEnvironmental()!=null && getEnvironmental().hasData()) return true;
			if (getAbandonmentOfScheme()!=null) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getFailureToDeliverApplicable()!=null) return true;
			if (getEEPParameters()!=null && getEEPParameters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder o = (EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getNumberOfAllowances(), o.getNumberOfAllowances(), this::setNumberOfAllowances);
			merger.mergeRosetta(getEnvironmental(), o.getEnvironmental(), this::setEnvironmental);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			merger.mergeRosetta(getEEPParameters(), o.getEEPParameters(), this::setEEPParameters);
			
			merger.mergeBasic(getAbandonmentOfScheme(), o.getAbandonmentOfScheme(), this::setAbandonmentOfScheme);
			merger.mergeBasic(getFailureToDeliverApplicable(), o.getFailureToDeliverApplicable(), this::setFailureToDeliverApplicable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EnvironmentalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(numberOfAllowances, _that.getNumberOfAllowances())) return false;
			if (!Objects.equals(environmental, _that.getEnvironmental())) return false;
			if (!Objects.equals(abandonmentOfScheme, _that.getAbandonmentOfScheme())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(failureToDeliverApplicable, _that.getFailureToDeliverApplicable())) return false;
			if (!Objects.equals(eEPParameters, _that.getEEPParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfAllowances != null ? numberOfAllowances.hashCode() : 0);
			_result = 31 * _result + (environmental != null ? environmental.hashCode() : 0);
			_result = 31 * _result + (abandonmentOfScheme != null ? abandonmentOfScheme.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (failureToDeliverApplicable != null ? failureToDeliverApplicable.hashCode() : 0);
			_result = 31 * _result + (eEPParameters != null ? eEPParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalPhysicalLegBuilder {" +
				"numberOfAllowances=" + this.numberOfAllowances + ", " +
				"environmental=" + this.environmental + ", " +
				"abandonmentOfScheme=" + this.abandonmentOfScheme + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"failureToDeliverApplicable=" + this.failureToDeliverApplicable + ", " +
				"eEPParameters=" + this.eEPParameters +
			'}' + " " + super.toString();
		}
	}
}
