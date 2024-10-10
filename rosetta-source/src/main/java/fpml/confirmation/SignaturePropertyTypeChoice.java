package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.SignaturePropertyTypeChoice;
import fpml.confirmation.SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder;
import fpml.confirmation.SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl;
import fpml.confirmation.SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceImpl;
import fpml.confirmation.meta.SignaturePropertyTypeChoiceMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignaturePropertyTypeChoice", builder=SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl.class, version="${project.version}")
public interface SignaturePropertyTypeChoice extends RosettaModelObject {

	SignaturePropertyTypeChoiceMeta metaData = new SignaturePropertyTypeChoiceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignaturePropertyTypeChoice build();
	
	SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder();
	
	static SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder() {
		return new SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertyTypeChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignaturePropertyTypeChoice> getType() {
		return SignaturePropertyTypeChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyTypeChoiceBuilder extends SignaturePropertyTypeChoice, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertyTypeChoice  ***********************/
	class SignaturePropertyTypeChoiceImpl implements SignaturePropertyTypeChoice {
		
		protected SignaturePropertyTypeChoiceImpl(SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder) {
		}
		
		@Override
		public SignaturePropertyTypeChoice build() {
			return this;
		}
		
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder() {
			SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder) {
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeChoice {" +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertyTypeChoice  ***********************/
	class SignaturePropertyTypeChoiceBuilderImpl implements SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder {
	
	
		public SignaturePropertyTypeChoiceBuilderImpl() {
		}
	
		
		@Override
		public SignaturePropertyTypeChoice build() {
			return new SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceImpl(this);
		}
		
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder o = (SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeChoiceBuilder {" +
			'}';
		}
	}
}
