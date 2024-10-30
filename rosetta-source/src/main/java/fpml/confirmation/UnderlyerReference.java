package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.UnderlyerReference;
import fpml.confirmation.UnderlyerReference.UnderlyerReferenceBuilder;
import fpml.confirmation.UnderlyerReference.UnderlyerReferenceBuilderImpl;
import fpml.confirmation.UnderlyerReference.UnderlyerReferenceImpl;
import fpml.confirmation.meta.UnderlyerReferenceMeta;


/**
 * Reference to an underlyer
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UnderlyerReference", builder=UnderlyerReference.UnderlyerReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UnderlyerReference extends Reference {

	UnderlyerReferenceMeta metaData = new UnderlyerReferenceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	UnderlyerReference build();
	
	UnderlyerReference.UnderlyerReferenceBuilder toBuilder();
	
	static UnderlyerReference.UnderlyerReferenceBuilder builder() {
		return new UnderlyerReference.UnderlyerReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyerReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyerReference> getType() {
		return UnderlyerReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerReferenceBuilder extends UnderlyerReference, Reference.ReferenceBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		UnderlyerReference.UnderlyerReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyerReference  ***********************/
	class UnderlyerReferenceImpl extends Reference.ReferenceImpl implements UnderlyerReference {
		
		protected UnderlyerReferenceImpl(UnderlyerReference.UnderlyerReferenceBuilder builder) {
			super(builder);
		}
		
		@Override
		public UnderlyerReference build() {
			return this;
		}
		
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder toBuilder() {
			UnderlyerReference.UnderlyerReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyerReference.UnderlyerReferenceBuilder builder) {
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
			return "UnderlyerReference {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyerReference  ***********************/
	class UnderlyerReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements UnderlyerReference.UnderlyerReferenceBuilder {
	
	
		public UnderlyerReferenceBuilderImpl() {
		}
	
		
		@Override
		public UnderlyerReference build() {
			return new UnderlyerReference.UnderlyerReferenceImpl(this);
		}
		
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder prune() {
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
		public UnderlyerReference.UnderlyerReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UnderlyerReference.UnderlyerReferenceBuilder o = (UnderlyerReference.UnderlyerReferenceBuilder) other;
			
			
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
			return "UnderlyerReferenceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
