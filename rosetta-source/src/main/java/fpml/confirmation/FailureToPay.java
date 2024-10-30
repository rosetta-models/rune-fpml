package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FailureToPay;
import fpml.confirmation.FailureToPay.FailureToPayBuilder;
import fpml.confirmation.FailureToPay.FailureToPayBuilderImpl;
import fpml.confirmation.FailureToPay.FailureToPayImpl;
import fpml.confirmation.FailureToPayEvent;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventBuilder;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventBuilderImpl;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventImpl;
import fpml.confirmation.meta.FailureToPayMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FailureToPay", builder=FailureToPay.FailureToPayBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FailureToPay extends FailureToPayEvent {

	FailureToPayMeta metaData = new FailureToPayMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FailureToPay build();
	
	FailureToPay.FailureToPayBuilder toBuilder();
	
	static FailureToPay.FailureToPayBuilder builder() {
		return new FailureToPay.FailureToPayBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FailureToPay> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FailureToPay> getType() {
		return FailureToPay.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface FailureToPayBuilder extends FailureToPay, FailureToPayEvent.FailureToPayEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		FailureToPay.FailureToPayBuilder prune();
	}

	/*********************** Immutable Implementation of FailureToPay  ***********************/
	class FailureToPayImpl extends FailureToPayEvent.FailureToPayEventImpl implements FailureToPay {
		
		protected FailureToPayImpl(FailureToPay.FailureToPayBuilder builder) {
			super(builder);
		}
		
		@Override
		public FailureToPay build() {
			return this;
		}
		
		@Override
		public FailureToPay.FailureToPayBuilder toBuilder() {
			FailureToPay.FailureToPayBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FailureToPay.FailureToPayBuilder builder) {
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
			return "FailureToPay {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FailureToPay  ***********************/
	class FailureToPayBuilderImpl extends FailureToPayEvent.FailureToPayEventBuilderImpl  implements FailureToPay.FailureToPayBuilder {
	
	
		public FailureToPayBuilderImpl() {
		}
	
		
		@Override
		public FailureToPay build() {
			return new FailureToPay.FailureToPayImpl(this);
		}
		
		@Override
		public FailureToPay.FailureToPayBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FailureToPay.FailureToPayBuilder prune() {
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
		public FailureToPay.FailureToPayBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FailureToPay.FailureToPayBuilder o = (FailureToPay.FailureToPayBuilder) other;
			
			
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
			return "FailureToPayBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
