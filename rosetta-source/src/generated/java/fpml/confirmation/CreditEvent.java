package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEvent.CreditEventBuilder;
import fpml.confirmation.CreditEvent.CreditEventBuilderImpl;
import fpml.confirmation.CreditEvent.CreditEventImpl;
import fpml.confirmation.meta.CreditEventMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEvent", builder=CreditEvent.CreditEventBuilderImpl.class, version="${project.version}")
public interface CreditEvent extends RosettaModelObject {

	CreditEventMeta metaData = new CreditEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditEvent build();
	
	CreditEvent.CreditEventBuilder toBuilder();
	
	static CreditEvent.CreditEventBuilder builder() {
		return new CreditEvent.CreditEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEvent> getType() {
		return CreditEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventBuilder extends CreditEvent, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		CreditEvent.CreditEventBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEvent  ***********************/
	class CreditEventImpl implements CreditEvent {
		
		protected CreditEventImpl(CreditEvent.CreditEventBuilder builder) {
		}
		
		@Override
		public CreditEvent build() {
			return this;
		}
		
		@Override
		public CreditEvent.CreditEventBuilder toBuilder() {
			CreditEvent.CreditEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEvent.CreditEventBuilder builder) {
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
			return "CreditEvent {" +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEvent  ***********************/
	class CreditEventBuilderImpl implements CreditEvent.CreditEventBuilder {
	
	
		public CreditEventBuilderImpl() {
		}
	
		
		@Override
		public CreditEvent build() {
			return new CreditEvent.CreditEventImpl(this);
		}
		
		@Override
		public CreditEvent.CreditEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvent.CreditEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvent.CreditEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEvent.CreditEventBuilder o = (CreditEvent.CreditEventBuilder) other;
			
			
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
			return "CreditEventBuilder {" +
			'}';
		}
	}
}
