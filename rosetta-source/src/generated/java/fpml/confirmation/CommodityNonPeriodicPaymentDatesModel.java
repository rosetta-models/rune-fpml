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
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilderImpl;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelImpl;
import fpml.confirmation.meta.CommodityNonPeriodicPaymentDatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Payment Date.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityNonPeriodicPaymentDatesModel", builder=CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilderImpl.class, version="${project.version}")
public interface CommodityNonPeriodicPaymentDatesModel extends RosettaModelObject {

	CommodityNonPeriodicPaymentDatesModelMeta metaData = new CommodityNonPeriodicPaymentDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Dates on which payments will be made.
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 * If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 */
	Boolean getMasterAgreementPaymentDates();

	/*********************** Build Methods  ***********************/
	CommodityNonPeriodicPaymentDatesModel build();
	
	CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder toBuilder();
	
	static CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder builder() {
		return new CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNonPeriodicPaymentDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNonPeriodicPaymentDatesModel> getType() {
		return CommodityNonPeriodicPaymentDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNonPeriodicPaymentDatesModelBuilder extends CommodityNonPeriodicPaymentDatesModel, RosettaModelObjectBuilder {
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		}
		

		CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNonPeriodicPaymentDatesModel  ***********************/
	class CommodityNonPeriodicPaymentDatesModelImpl implements CommodityNonPeriodicPaymentDatesModel {
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		
		protected CommodityNonPeriodicPaymentDatesModelImpl(CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder builder) {
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		public CommodityNonPeriodicPaymentDatesModel build() {
			return this;
		}
		
		@Override
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder toBuilder() {
			CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder builder) {
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNonPeriodicPaymentDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNonPeriodicPaymentDatesModel {" +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNonPeriodicPaymentDatesModel  ***********************/
	class CommodityNonPeriodicPaymentDatesModelBuilderImpl implements CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder {
	
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
	
		public CommodityNonPeriodicPaymentDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = masterAgreementPaymentDates==null?null:masterAgreementPaymentDates;
			return this;
		}
		
		@Override
		public CommodityNonPeriodicPaymentDatesModel build() {
			return new CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelImpl(this);
		}
		
		@Override
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder prune() {
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder o = (CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder) other;
			
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNonPeriodicPaymentDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNonPeriodicPaymentDatesModelBuilder {" +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}
}
