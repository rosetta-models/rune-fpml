package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Bankruptcy;
import fpml.confirmation.Bankruptcy.BankruptcyBuilder;
import fpml.confirmation.Bankruptcy.BankruptcyBuilderImpl;
import fpml.confirmation.Bankruptcy.BankruptcyImpl;
import fpml.confirmation.BankruptcyEvent;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventBuilder;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventBuilderImpl;
import fpml.confirmation.BankruptcyEvent.BankruptcyEventImpl;
import fpml.confirmation.meta.BankruptcyMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Bankruptcy", builder=Bankruptcy.BankruptcyBuilderImpl.class, version="${project.version}")
public interface Bankruptcy extends BankruptcyEvent {

	BankruptcyMeta metaData = new BankruptcyMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Bankruptcy build();
	
	Bankruptcy.BankruptcyBuilder toBuilder();
	
	static Bankruptcy.BankruptcyBuilder builder() {
		return new Bankruptcy.BankruptcyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Bankruptcy> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Bankruptcy> getType() {
		return Bankruptcy.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface BankruptcyBuilder extends Bankruptcy, BankruptcyEvent.BankruptcyEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		Bankruptcy.BankruptcyBuilder prune();
	}

	/*********************** Immutable Implementation of Bankruptcy  ***********************/
	class BankruptcyImpl extends BankruptcyEvent.BankruptcyEventImpl implements Bankruptcy {
		
		protected BankruptcyImpl(Bankruptcy.BankruptcyBuilder builder) {
			super(builder);
		}
		
		@Override
		public Bankruptcy build() {
			return this;
		}
		
		@Override
		public Bankruptcy.BankruptcyBuilder toBuilder() {
			Bankruptcy.BankruptcyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Bankruptcy.BankruptcyBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "Bankruptcy {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Bankruptcy  ***********************/
	class BankruptcyBuilderImpl extends BankruptcyEvent.BankruptcyEventBuilderImpl  implements Bankruptcy.BankruptcyBuilder {
	
	
		public BankruptcyBuilderImpl() {
		}
	
		
		@Override
		public Bankruptcy build() {
			return new Bankruptcy.BankruptcyImpl(this);
		}
		
		@Override
		public Bankruptcy.BankruptcyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bankruptcy.BankruptcyBuilder prune() {
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
		public Bankruptcy.BankruptcyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Bankruptcy.BankruptcyBuilder o = (Bankruptcy.BankruptcyBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "BankruptcyBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
