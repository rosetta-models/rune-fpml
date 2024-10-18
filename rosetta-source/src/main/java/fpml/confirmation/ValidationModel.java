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
import fpml.confirmation.Validation;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.ValidationModel.ValidationModelBuilder;
import fpml.confirmation.ValidationModel.ValidationModelBuilderImpl;
import fpml.confirmation.ValidationModel.ValidationModelImpl;
import fpml.confirmation.meta.ValidationModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ValidationModel", builder=ValidationModel.ValidationModelBuilderImpl.class, version="${project.version}")
public interface ValidationModel extends RosettaModelObject {

	ValidationModelMeta metaData = new ValidationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A list of validation sets the sender asserts the document is valid with respect to.
	 */
	List<? extends Validation> getValidation();

	/*********************** Build Methods  ***********************/
	ValidationModel build();
	
	ValidationModel.ValidationModelBuilder toBuilder();
	
	static ValidationModel.ValidationModelBuilder builder() {
		return new ValidationModel.ValidationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValidationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValidationModel> getType() {
		return ValidationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValidationModelBuilder extends ValidationModel, RosettaModelObjectBuilder {
		Validation.ValidationBuilder getOrCreateValidation(int _index);
		List<? extends Validation.ValidationBuilder> getValidation();
		ValidationModel.ValidationModelBuilder addValidation(Validation validation0);
		ValidationModel.ValidationModelBuilder addValidation(Validation validation1, int _idx);
		ValidationModel.ValidationModelBuilder addValidation(List<? extends Validation> validation2);
		ValidationModel.ValidationModelBuilder setValidation(List<? extends Validation> validation3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
		}
		

		ValidationModel.ValidationModelBuilder prune();
	}

	/*********************** Immutable Implementation of ValidationModel  ***********************/
	class ValidationModelImpl implements ValidationModel {
		private final List<? extends Validation> validation;
		
		protected ValidationModelImpl(ValidationModel.ValidationModelBuilder builder) {
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("validation")
		public List<? extends Validation> getValidation() {
			return validation;
		}
		
		@Override
		public ValidationModel build() {
			return this;
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder toBuilder() {
			ValidationModel.ValidationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValidationModel.ValidationModelBuilder builder) {
			ofNullable(getValidation()).ifPresent(builder::setValidation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValidationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValidationModel {" +
				"validation=" + this.validation +
			'}';
		}
	}

	/*********************** Builder Implementation of ValidationModel  ***********************/
	class ValidationModelBuilderImpl implements ValidationModel.ValidationModelBuilder {
	
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
	
		public ValidationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("validation")
		public List<? extends Validation.ValidationBuilder> getValidation() {
			return validation;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidation(int _index) {
		
			if (validation==null) {
				this.validation = new ArrayList<>();
			}
			Validation.ValidationBuilder result;
			return getIndex(validation, _index, () -> {
						Validation.ValidationBuilder newValidation = Validation.builder();
						return newValidation;
					});
		}
		
		@Override
		@RosettaAttribute("validation")
		public ValidationModel.ValidationModelBuilder addValidation(Validation validation) {
			if (validation!=null) this.validation.add(validation.toBuilder());
			return this;
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder addValidation(Validation validation, int _idx) {
			getIndex(this.validation, _idx, () -> validation.toBuilder());
			return this;
		}
		@Override 
		public ValidationModel.ValidationModelBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ValidationModel.ValidationModelBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null)  {
				this.validation = new ArrayList<>();
			}
			else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ValidationModel build() {
			return new ValidationModel.ValidationModelImpl(this);
		}
		
		@Override
		public ValidationModel.ValidationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValidationModel.ValidationModelBuilder prune() {
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValidation()!=null && getValidation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValidationModel.ValidationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValidationModel.ValidationModelBuilder o = (ValidationModel.ValidationModelBuilder) other;
			
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValidationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValidationModelBuilder {" +
				"validation=" + this.validation +
			'}';
		}
	}
}
