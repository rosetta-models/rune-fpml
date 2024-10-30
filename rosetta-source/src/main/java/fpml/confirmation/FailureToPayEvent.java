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
import fpml.confirmation.FailureToPayEvent;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventBuilder;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventBuilderImpl;
import fpml.confirmation.FailureToPayEvent.FailureToPayEventImpl;
import fpml.confirmation.meta.FailureToPayEventMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FailureToPayEvent", builder=FailureToPayEvent.FailureToPayEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FailureToPayEvent extends CreditEvent {

	FailureToPayEventMeta metaData = new FailureToPayEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FailureToPayEvent build();
	
	FailureToPayEvent.FailureToPayEventBuilder toBuilder();
	
	static FailureToPayEvent.FailureToPayEventBuilder builder() {
		return new FailureToPayEvent.FailureToPayEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FailureToPayEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FailureToPayEvent> getType() {
		return FailureToPayEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface FailureToPayEventBuilder extends FailureToPayEvent, CreditEvent.CreditEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		FailureToPayEvent.FailureToPayEventBuilder prune();
	}

	/*********************** Immutable Implementation of FailureToPayEvent  ***********************/
	class FailureToPayEventImpl extends CreditEvent.CreditEventImpl implements FailureToPayEvent {
		
		protected FailureToPayEventImpl(FailureToPayEvent.FailureToPayEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public FailureToPayEvent build() {
			return this;
		}
		
		@Override
		public FailureToPayEvent.FailureToPayEventBuilder toBuilder() {
			FailureToPayEvent.FailureToPayEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FailureToPayEvent.FailureToPayEventBuilder builder) {
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
			return "FailureToPayEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FailureToPayEvent  ***********************/
	class FailureToPayEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl  implements FailureToPayEvent.FailureToPayEventBuilder {
	
	
		public FailureToPayEventBuilderImpl() {
		}
	
		
		@Override
		public FailureToPayEvent build() {
			return new FailureToPayEvent.FailureToPayEventImpl(this);
		}
		
		@Override
		public FailureToPayEvent.FailureToPayEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FailureToPayEvent.FailureToPayEventBuilder prune() {
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
		public FailureToPayEvent.FailureToPayEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FailureToPayEvent.FailureToPayEventBuilder o = (FailureToPayEvent.FailureToPayEventBuilder) other;
			
			
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
			return "FailureToPayEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
