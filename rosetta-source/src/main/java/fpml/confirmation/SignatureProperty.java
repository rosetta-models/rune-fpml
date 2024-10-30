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
import fpml.confirmation.SignatureProperty;
import fpml.confirmation.SignatureProperty.SignaturePropertyBuilder;
import fpml.confirmation.SignatureProperty.SignaturePropertyBuilderImpl;
import fpml.confirmation.SignatureProperty.SignaturePropertyImpl;
import fpml.confirmation.SignaturePropertyType;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeBuilder;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeBuilderImpl;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeImpl;
import fpml.confirmation.SignaturePropertyTypeChoice;
import fpml.confirmation.meta.SignaturePropertyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SignatureProperty", builder=SignatureProperty.SignaturePropertyBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SignatureProperty extends SignaturePropertyType {

	SignaturePropertyMeta metaData = new SignaturePropertyMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureProperty build();
	
	SignatureProperty.SignaturePropertyBuilder toBuilder();
	
	static SignatureProperty.SignaturePropertyBuilder builder() {
		return new SignatureProperty.SignaturePropertyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureProperty> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignatureProperty> getType() {
		return SignatureProperty.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.class, getSignaturePropertyTypeChoice());
		processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyBuilder extends SignatureProperty, SignaturePropertyType.SignaturePropertyTypeBuilder {
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice0);
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice1, int _idx);
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice2);
		SignatureProperty.SignaturePropertyBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice3);
		SignatureProperty.SignaturePropertyBuilder setTarget(String target);
		SignatureProperty.SignaturePropertyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder.class, getSignaturePropertyTypeChoice());
			processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureProperty.SignaturePropertyBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureProperty  ***********************/
	class SignaturePropertyImpl extends SignaturePropertyType.SignaturePropertyTypeImpl implements SignatureProperty {
		
		protected SignaturePropertyImpl(SignatureProperty.SignaturePropertyBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureProperty build() {
			return this;
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder toBuilder() {
			SignatureProperty.SignaturePropertyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureProperty.SignaturePropertyBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureProperty {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureProperty  ***********************/
	class SignaturePropertyBuilderImpl extends SignaturePropertyType.SignaturePropertyTypeBuilderImpl  implements SignatureProperty.SignaturePropertyBuilder {
	
	
		public SignaturePropertyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signaturePropertyTypeChoice")
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice) {
			if (signaturePropertyTypeChoice!=null) this.signaturePropertyTypeChoice.add(signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice, int _idx) {
			getIndex(this.signaturePropertyTypeChoice, _idx, () -> signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices != null) {
				for (SignaturePropertyTypeChoice toAdd : signaturePropertyTypeChoices) {
					this.signaturePropertyTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SignatureProperty.SignaturePropertyBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices == null)  {
				this.signaturePropertyTypeChoice = new ArrayList<>();
			}
			else {
				this.signaturePropertyTypeChoice = signaturePropertyTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("target")
		public SignatureProperty.SignaturePropertyBuilder setTarget(String target) {
			this.target = target==null?null:target;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SignatureProperty.SignaturePropertyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignatureProperty build() {
			return new SignatureProperty.SignaturePropertyImpl(this);
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperty.SignaturePropertyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperty.SignaturePropertyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SignatureProperty.SignaturePropertyBuilder o = (SignatureProperty.SignaturePropertyBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
