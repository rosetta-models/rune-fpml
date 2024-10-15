package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.BankruptcyEvent;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventBuilder;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventBuilderImpl;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventImpl;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEvent.CreditEventBuilder;
import fpml.confirmation.CreditEvent.CreditEventBuilderImpl;
import fpml.confirmation.CreditEvent.CreditEventImpl;
import fpml.confirmation.meta.BankruptcyEventMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="BankruptcyEvent", builder=BankruptcyEvent.BankruptcyEventBuilderImpl.class, version="${project.version}")
public interface BankruptcyEvent extends CreditEvent {

	BankruptcyEventMeta metaData = new BankruptcyEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	BankruptcyEvent build();
	
	BankruptcyEvent.BankruptcyEventBuilder toBuilder();
	
	static BankruptcyEvent.BankruptcyEventBuilder builder() {
		return new BankruptcyEvent.BankruptcyEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BankruptcyEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BankruptcyEvent> getType() {
		return BankruptcyEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface BankruptcyEventBuilder extends BankruptcyEvent, CreditEvent.CreditEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		BankruptcyEvent.BankruptcyEventBuilder prune();
	}

	/*********************** Immutable Implementation of BankruptcyEvent  ***********************/
	class BankruptcyEventImpl extends CreditEvent.CreditEventImpl implements BankruptcyEvent {
		
		protected BankruptcyEventImpl(BankruptcyEvent.BankruptcyEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public BankruptcyEvent build() {
			return this;
		}
		
		@Override
		public BankruptcyEvent.BankruptcyEventBuilder toBuilder() {
			BankruptcyEvent.BankruptcyEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BankruptcyEvent.BankruptcyEventBuilder builder) {
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
			return "BankruptcyEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BankruptcyEvent  ***********************/
	class BankruptcyEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl  implements BankruptcyEvent.BankruptcyEventBuilder {
	
	
		public BankruptcyEventBuilderImpl() {
		}
	
		
		@Override
		public BankruptcyEvent build() {
			return new BankruptcyEvent.BankruptcyEventImpl(this);
		}
		
		@Override
		public BankruptcyEvent.BankruptcyEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BankruptcyEvent.BankruptcyEventBuilder prune() {
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
		public BankruptcyEvent.BankruptcyEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BankruptcyEvent.BankruptcyEventBuilder o = (BankruptcyEvent.BankruptcyEventBuilder) other;
			
			
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
			return "BankruptcyEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
