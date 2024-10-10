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
import fpml.confirmation.Collateral;
import fpml.confirmation.Collateral.CollateralBuilder;
import fpml.confirmation.Collateral.CollateralBuilderImpl;
import fpml.confirmation.Collateral.CollateralImpl;
import fpml.confirmation.IndependentAmount;
import fpml.confirmation.meta.CollateralMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the obligations of the counterparty subject to credit support requirements.
 * @version ${project.version}
 */
@RosettaDataType(value="Collateral", builder=Collateral.CollateralBuilderImpl.class, version="${project.version}")
public interface Collateral extends RosettaModelObject {

	CollateralMeta metaData = new CollateralMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction&#39;s value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party&#39;s account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. (&quot;with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero&quot;).
	 */
	IndependentAmount getIndependentAmount();

	/*********************** Build Methods  ***********************/
	Collateral build();
	
	Collateral.CollateralBuilder toBuilder();
	
	static Collateral.CollateralBuilder builder() {
		return new Collateral.CollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Collateral> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Collateral> getType() {
		return Collateral.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.class, getIndependentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralBuilder extends Collateral, RosettaModelObjectBuilder {
		IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount();
		IndependentAmount.IndependentAmountBuilder getIndependentAmount();
		Collateral.CollateralBuilder setIndependentAmount(IndependentAmount independentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.IndependentAmountBuilder.class, getIndependentAmount());
		}
		

		Collateral.CollateralBuilder prune();
	}

	/*********************** Immutable Implementation of Collateral  ***********************/
	class CollateralImpl implements Collateral {
		private final IndependentAmount independentAmount;
		
		protected CollateralImpl(Collateral.CollateralBuilder builder) {
			this.independentAmount = ofNullable(builder.getIndependentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("independentAmount")
		public IndependentAmount getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public Collateral build() {
			return this;
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			Collateral.CollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Collateral.CollateralBuilder builder) {
			ofNullable(getIndependentAmount()).ifPresent(builder::setIndependentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!Objects.equals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Collateral {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of Collateral  ***********************/
	class CollateralBuilderImpl implements Collateral.CollateralBuilder {
	
		protected IndependentAmount.IndependentAmountBuilder independentAmount;
	
		public CollateralBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("independentAmount")
		public IndependentAmount.IndependentAmountBuilder getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount() {
			IndependentAmount.IndependentAmountBuilder result;
			if (independentAmount!=null) {
				result = independentAmount;
			}
			else {
				result = independentAmount = IndependentAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("independentAmount")
		public Collateral.CollateralBuilder setIndependentAmount(IndependentAmount independentAmount) {
			this.independentAmount = independentAmount==null?null:independentAmount.toBuilder();
			return this;
		}
		
		@Override
		public Collateral build() {
			return new Collateral.CollateralImpl(this);
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder prune() {
			if (independentAmount!=null && !independentAmount.prune().hasData()) independentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndependentAmount()!=null && getIndependentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Collateral.CollateralBuilder o = (Collateral.CollateralBuilder) other;
			
			merger.mergeRosetta(getIndependentAmount(), o.getIndependentAmount(), this::setIndependentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!Objects.equals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralBuilder {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}
}
