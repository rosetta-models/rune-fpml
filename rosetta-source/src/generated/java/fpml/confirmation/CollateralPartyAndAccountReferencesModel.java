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
import fpml.confirmation.AccountReference;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilderImpl;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.CollateralPartyAndAccountReferencesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralPartyAndAccountReferencesModel", builder=CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilderImpl.class, version="${project.version}")
public interface CollateralPartyAndAccountReferencesModel extends RosettaModelObject {

	CollateralPartyAndAccountReferencesModelMeta metaData = new CollateralPartyAndAccountReferencesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a party.
	 */
	PartyReference getAllocationPartyReference();
	/**
	 * Reference to an account.
	 */
	AccountReference getAllocationAccountReference();

	/*********************** Build Methods  ***********************/
	CollateralPartyAndAccountReferencesModel build();
	
	CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder toBuilder();
	
	static CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder builder() {
		return new CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPartyAndAccountReferencesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralPartyAndAccountReferencesModel> getType() {
		return CollateralPartyAndAccountReferencesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationPartyReference"), processor, PartyReference.class, getAllocationPartyReference());
		processRosetta(path.newSubPath("allocationAccountReference"), processor, AccountReference.class, getAllocationAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPartyAndAccountReferencesModelBuilder extends CollateralPartyAndAccountReferencesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAllocationPartyReference();
		PartyReference.PartyReferenceBuilder getAllocationPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAllocationAccountReference();
		AccountReference.AccountReferenceBuilder getAllocationAccountReference();
		CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder setAllocationPartyReference(PartyReference allocationPartyReference);
		CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder setAllocationAccountReference(AccountReference allocationAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAllocationPartyReference());
			processRosetta(path.newSubPath("allocationAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAllocationAccountReference());
		}
		

		CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPartyAndAccountReferencesModel  ***********************/
	class CollateralPartyAndAccountReferencesModelImpl implements CollateralPartyAndAccountReferencesModel {
		private final PartyReference allocationPartyReference;
		private final AccountReference allocationAccountReference;
		
		protected CollateralPartyAndAccountReferencesModelImpl(CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder builder) {
			this.allocationPartyReference = ofNullable(builder.getAllocationPartyReference()).map(f->f.build()).orElse(null);
			this.allocationAccountReference = ofNullable(builder.getAllocationAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationPartyReference")
		public PartyReference getAllocationPartyReference() {
			return allocationPartyReference;
		}
		
		@Override
		@RosettaAttribute("allocationAccountReference")
		public AccountReference getAllocationAccountReference() {
			return allocationAccountReference;
		}
		
		@Override
		public CollateralPartyAndAccountReferencesModel build() {
			return this;
		}
		
		@Override
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder toBuilder() {
			CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder builder) {
			ofNullable(getAllocationPartyReference()).ifPresent(builder::setAllocationPartyReference);
			ofNullable(getAllocationAccountReference()).ifPresent(builder::setAllocationAccountReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPartyAndAccountReferencesModel _that = getType().cast(o);
		
			if (!Objects.equals(allocationPartyReference, _that.getAllocationPartyReference())) return false;
			if (!Objects.equals(allocationAccountReference, _that.getAllocationAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationPartyReference != null ? allocationPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocationAccountReference != null ? allocationAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPartyAndAccountReferencesModel {" +
				"allocationPartyReference=" + this.allocationPartyReference + ", " +
				"allocationAccountReference=" + this.allocationAccountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPartyAndAccountReferencesModel  ***********************/
	class CollateralPartyAndAccountReferencesModelBuilderImpl implements CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder allocationPartyReference;
		protected AccountReference.AccountReferenceBuilder allocationAccountReference;
	
		public CollateralPartyAndAccountReferencesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationPartyReference")
		public PartyReference.PartyReferenceBuilder getAllocationPartyReference() {
			return allocationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAllocationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (allocationPartyReference!=null) {
				result = allocationPartyReference;
			}
			else {
				result = allocationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationAccountReference")
		public AccountReference.AccountReferenceBuilder getAllocationAccountReference() {
			return allocationAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAllocationAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (allocationAccountReference!=null) {
				result = allocationAccountReference;
			}
			else {
				result = allocationAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationPartyReference")
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder setAllocationPartyReference(PartyReference allocationPartyReference) {
			this.allocationPartyReference = allocationPartyReference==null?null:allocationPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocationAccountReference")
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder setAllocationAccountReference(AccountReference allocationAccountReference) {
			this.allocationAccountReference = allocationAccountReference==null?null:allocationAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPartyAndAccountReferencesModel build() {
			return new CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelImpl(this);
		}
		
		@Override
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder prune() {
			if (allocationPartyReference!=null && !allocationPartyReference.prune().hasData()) allocationPartyReference = null;
			if (allocationAccountReference!=null && !allocationAccountReference.prune().hasData()) allocationAccountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationPartyReference()!=null && getAllocationPartyReference().hasData()) return true;
			if (getAllocationAccountReference()!=null && getAllocationAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder o = (CollateralPartyAndAccountReferencesModel.CollateralPartyAndAccountReferencesModelBuilder) other;
			
			merger.mergeRosetta(getAllocationPartyReference(), o.getAllocationPartyReference(), this::setAllocationPartyReference);
			merger.mergeRosetta(getAllocationAccountReference(), o.getAllocationAccountReference(), this::setAllocationAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPartyAndAccountReferencesModel _that = getType().cast(o);
		
			if (!Objects.equals(allocationPartyReference, _that.getAllocationPartyReference())) return false;
			if (!Objects.equals(allocationAccountReference, _that.getAllocationAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationPartyReference != null ? allocationPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocationAccountReference != null ? allocationAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPartyAndAccountReferencesModelBuilder {" +
				"allocationPartyReference=" + this.allocationPartyReference + ", " +
				"allocationAccountReference=" + this.allocationAccountReference +
			'}';
		}
	}
}
