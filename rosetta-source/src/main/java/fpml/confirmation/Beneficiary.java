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
import fpml.confirmation.Beneficiary;
import fpml.confirmation.Beneficiary.BeneficiaryBuilder;
import fpml.confirmation.Beneficiary.BeneficiaryBuilderImpl;
import fpml.confirmation.Beneficiary.BeneficiaryImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.meta.BeneficiaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the beneficiary of the funds.
 * @version ${project.version}
 */
@RosettaDataType(value="Beneficiary", builder=Beneficiary.BeneficiaryBuilderImpl.class, version="${project.version}")
public interface Beneficiary extends RosettaModelObject {

	BeneficiaryMeta metaData = new BeneficiaryMeta();

	/*********************** Getter Methods  ***********************/
	RoutingIdentificationModel getRoutingIdentificationModel();
	/**
	 * Link to the party acting as beneficiary. This element can only appear within the beneficiary container element.
	 */
	PartyReference getBeneficiaryPartyReference();

	/*********************** Build Methods  ***********************/
	Beneficiary build();
	
	Beneficiary.BeneficiaryBuilder toBuilder();
	
	static Beneficiary.BeneficiaryBuilder builder() {
		return new Beneficiary.BeneficiaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Beneficiary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Beneficiary> getType() {
		return Beneficiary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.class, getRoutingIdentificationModel());
		processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.class, getBeneficiaryPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BeneficiaryBuilder extends Beneficiary, RosettaModelObjectBuilder {
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel();
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel();
		PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference();
		PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference();
		Beneficiary.BeneficiaryBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel);
		Beneficiary.BeneficiaryBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.RoutingIdentificationModelBuilder.class, getRoutingIdentificationModel());
			processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBeneficiaryPartyReference());
		}
		

		Beneficiary.BeneficiaryBuilder prune();
	}

	/*********************** Immutable Implementation of Beneficiary  ***********************/
	class BeneficiaryImpl implements Beneficiary {
		private final RoutingIdentificationModel routingIdentificationModel;
		private final PartyReference beneficiaryPartyReference;
		
		protected BeneficiaryImpl(Beneficiary.BeneficiaryBuilder builder) {
			this.routingIdentificationModel = ofNullable(builder.getRoutingIdentificationModel()).map(f->f.build()).orElse(null);
			this.beneficiaryPartyReference = ofNullable(builder.getBeneficiaryPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public PartyReference getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public Beneficiary build() {
			return this;
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder toBuilder() {
			Beneficiary.BeneficiaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Beneficiary.BeneficiaryBuilder builder) {
			ofNullable(getRoutingIdentificationModel()).ifPresent(builder::setRoutingIdentificationModel);
			ofNullable(getBeneficiaryPartyReference()).ifPresent(builder::setBeneficiaryPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Beneficiary _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Beneficiary {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of Beneficiary  ***********************/
	class BeneficiaryBuilderImpl implements Beneficiary.BeneficiaryBuilder {
	
		protected RoutingIdentificationModel.RoutingIdentificationModelBuilder routingIdentificationModel;
		protected PartyReference.PartyReferenceBuilder beneficiaryPartyReference;
	
		public BeneficiaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel() {
			RoutingIdentificationModel.RoutingIdentificationModelBuilder result;
			if (routingIdentificationModel!=null) {
				result = routingIdentificationModel;
			}
			else {
				result = routingIdentificationModel = RoutingIdentificationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (beneficiaryPartyReference!=null) {
				result = beneficiaryPartyReference;
			}
			else {
				result = beneficiaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public Beneficiary.BeneficiaryBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel) {
			this.routingIdentificationModel = routingIdentificationModel==null?null:routingIdentificationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		public Beneficiary.BeneficiaryBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference) {
			this.beneficiaryPartyReference = beneficiaryPartyReference==null?null:beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public Beneficiary build() {
			return new Beneficiary.BeneficiaryImpl(this);
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Beneficiary.BeneficiaryBuilder prune() {
			if (routingIdentificationModel!=null && !routingIdentificationModel.prune().hasData()) routingIdentificationModel = null;
			if (beneficiaryPartyReference!=null && !beneficiaryPartyReference.prune().hasData()) beneficiaryPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIdentificationModel()!=null && getRoutingIdentificationModel().hasData()) return true;
			if (getBeneficiaryPartyReference()!=null && getBeneficiaryPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Beneficiary.BeneficiaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Beneficiary.BeneficiaryBuilder o = (Beneficiary.BeneficiaryBuilder) other;
			
			merger.mergeRosetta(getRoutingIdentificationModel(), o.getRoutingIdentificationModel(), this::setRoutingIdentificationModel);
			merger.mergeRosetta(getBeneficiaryPartyReference(), o.getBeneficiaryPartyReference(), this::setBeneficiaryPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Beneficiary _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BeneficiaryBuilder {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}
}
