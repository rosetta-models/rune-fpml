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
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.CreditEntityModel.CreditEntityModelBuilder;
import fpml.confirmation.CreditEntityModel.CreditEntityModelBuilderImpl;
import fpml.confirmation.CreditEntityModel.CreditEntityModelImpl;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.meta.CreditEntityModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An item which has credit characteristics that can be modeled, e.g. a firm, index, or region.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEntityModel", builder=CreditEntityModel.CreditEntityModelBuilderImpl.class, version="${project.version}")
public interface CreditEntityModel extends RosettaModelObject {

	CreditEntityModelMeta metaData = new CreditEntityModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The entity for which this is defined.
	 */
	LegalEntity getReferenceEntity();
	/**
	 * An XML reference a credit entity defined elsewhere in the document.
	 */
	LegalEntityReference getCreditEntityReference();

	/*********************** Build Methods  ***********************/
	CreditEntityModel build();
	
	CreditEntityModel.CreditEntityModelBuilder toBuilder();
	
	static CreditEntityModel.CreditEntityModelBuilder builder() {
		return new CreditEntityModel.CreditEntityModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEntityModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEntityModel> getType() {
		return CreditEntityModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.class, getCreditEntityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEntityModelBuilder extends CreditEntityModel, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference();
		LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference();
		CreditEntityModel.CreditEntityModelBuilder setReferenceEntity(LegalEntity referenceEntity);
		CreditEntityModel.CreditEntityModelBuilder setCreditEntityReference(LegalEntityReference creditEntityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getCreditEntityReference());
		}
		

		CreditEntityModel.CreditEntityModelBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEntityModel  ***********************/
	class CreditEntityModelImpl implements CreditEntityModel {
		private final LegalEntity referenceEntity;
		private final LegalEntityReference creditEntityReference;
		
		protected CreditEntityModelImpl(CreditEntityModel.CreditEntityModelBuilder builder) {
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.creditEntityReference = ofNullable(builder.getCreditEntityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		public LegalEntityReference getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		public CreditEntityModel build() {
			return this;
		}
		
		@Override
		public CreditEntityModel.CreditEntityModelBuilder toBuilder() {
			CreditEntityModel.CreditEntityModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEntityModel.CreditEntityModelBuilder builder) {
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getCreditEntityReference()).ifPresent(builder::setCreditEntityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEntityModel _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEntityModel {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEntityModel  ***********************/
	class CreditEntityModelBuilderImpl implements CreditEntityModel.CreditEntityModelBuilder {
	
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected LegalEntityReference.LegalEntityReferenceBuilder creditEntityReference;
	
		public CreditEntityModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (creditEntityReference!=null) {
				result = creditEntityReference;
			}
			else {
				result = creditEntityReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public CreditEntityModel.CreditEntityModelBuilder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEntityReference")
		public CreditEntityModel.CreditEntityModelBuilder setCreditEntityReference(LegalEntityReference creditEntityReference) {
			this.creditEntityReference = creditEntityReference==null?null:creditEntityReference.toBuilder();
			return this;
		}
		
		@Override
		public CreditEntityModel build() {
			return new CreditEntityModel.CreditEntityModelImpl(this);
		}
		
		@Override
		public CreditEntityModel.CreditEntityModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEntityModel.CreditEntityModelBuilder prune() {
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (creditEntityReference!=null && !creditEntityReference.prune().hasData()) creditEntityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getCreditEntityReference()!=null && getCreditEntityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEntityModel.CreditEntityModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEntityModel.CreditEntityModelBuilder o = (CreditEntityModel.CreditEntityModelBuilder) other;
			
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getCreditEntityReference(), o.getCreditEntityReference(), this::setCreditEntityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEntityModel _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEntityModelBuilder {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference +
			'}';
		}
	}
}
