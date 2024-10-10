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
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.PartyProfileDocumentation.PartyProfileDocumentationBuilder;
import fpml.confirmation.PartyProfileDocumentation.PartyProfileDocumentationBuilderImpl;
import fpml.confirmation.PartyProfileDocumentation.PartyProfileDocumentationImpl;
import fpml.confirmation.TaxForm;
import fpml.confirmation.meta.PartyProfileDocumentationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines documentation related to a party profile.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyProfileDocumentation", builder=PartyProfileDocumentation.PartyProfileDocumentationBuilderImpl.class, version="${project.version}")
public interface PartyProfileDocumentation extends RosettaModelObject {

	PartyProfileDocumentationMeta metaData = new PartyProfileDocumentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Type of tax form registered.
	 */
	TaxForm getTaxForm();

	/*********************** Build Methods  ***********************/
	PartyProfileDocumentation build();
	
	PartyProfileDocumentation.PartyProfileDocumentationBuilder toBuilder();
	
	static PartyProfileDocumentation.PartyProfileDocumentationBuilder builder() {
		return new PartyProfileDocumentation.PartyProfileDocumentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileDocumentation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyProfileDocumentation> getType() {
		return PartyProfileDocumentation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("taxForm"), processor, TaxForm.class, getTaxForm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileDocumentationBuilder extends PartyProfileDocumentation, RosettaModelObjectBuilder {
		TaxForm.TaxFormBuilder getOrCreateTaxForm();
		TaxForm.TaxFormBuilder getTaxForm();
		PartyProfileDocumentation.PartyProfileDocumentationBuilder setTaxForm(TaxForm taxForm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taxForm"), processor, TaxForm.TaxFormBuilder.class, getTaxForm());
		}
		

		PartyProfileDocumentation.PartyProfileDocumentationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileDocumentation  ***********************/
	class PartyProfileDocumentationImpl implements PartyProfileDocumentation {
		private final TaxForm taxForm;
		
		protected PartyProfileDocumentationImpl(PartyProfileDocumentation.PartyProfileDocumentationBuilder builder) {
			this.taxForm = ofNullable(builder.getTaxForm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("taxForm")
		public TaxForm getTaxForm() {
			return taxForm;
		}
		
		@Override
		public PartyProfileDocumentation build() {
			return this;
		}
		
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder toBuilder() {
			PartyProfileDocumentation.PartyProfileDocumentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileDocumentation.PartyProfileDocumentationBuilder builder) {
			ofNullable(getTaxForm()).ifPresent(builder::setTaxForm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileDocumentation _that = getType().cast(o);
		
			if (!Objects.equals(taxForm, _that.getTaxForm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxForm != null ? taxForm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileDocumentation {" +
				"taxForm=" + this.taxForm +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileDocumentation  ***********************/
	class PartyProfileDocumentationBuilderImpl implements PartyProfileDocumentation.PartyProfileDocumentationBuilder {
	
		protected TaxForm.TaxFormBuilder taxForm;
	
		public PartyProfileDocumentationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("taxForm")
		public TaxForm.TaxFormBuilder getTaxForm() {
			return taxForm;
		}
		
		@Override
		public TaxForm.TaxFormBuilder getOrCreateTaxForm() {
			TaxForm.TaxFormBuilder result;
			if (taxForm!=null) {
				result = taxForm;
			}
			else {
				result = taxForm = TaxForm.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taxForm")
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder setTaxForm(TaxForm taxForm) {
			this.taxForm = taxForm==null?null:taxForm.toBuilder();
			return this;
		}
		
		@Override
		public PartyProfileDocumentation build() {
			return new PartyProfileDocumentation.PartyProfileDocumentationImpl(this);
		}
		
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder prune() {
			if (taxForm!=null && !taxForm.prune().hasData()) taxForm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaxForm()!=null && getTaxForm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileDocumentation.PartyProfileDocumentationBuilder o = (PartyProfileDocumentation.PartyProfileDocumentationBuilder) other;
			
			merger.mergeRosetta(getTaxForm(), o.getTaxForm(), this::setTaxForm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileDocumentation _that = getType().cast(o);
		
			if (!Objects.equals(taxForm, _that.getTaxForm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxForm != null ? taxForm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileDocumentationBuilder {" +
				"taxForm=" + this.taxForm +
			'}';
		}
	}
}
