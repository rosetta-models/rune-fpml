package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.InterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0-dev.76
 */
@RosettaDataRule("InterestRateIndexInterestRateAssetClass")
@ImplementedBy(InterestRateIndexInterestRateAssetClass.Default.class)
public interface InterestRateIndexInterestRateAssetClass extends Validator<InterestRateIndex> {
	
	String NAME = "InterestRateIndexInterestRateAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> InterestRate";
	
	ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex);
	
	class Default implements InterestRateIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex) {
			ComparisonResult result = executeDataRule(interestRateIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InterestRateIndex interestRateIndex) {
			try {
				return areEqual(MapperS.of(interestRateIndex).<AssetClassEnum>map("getAssetClass", _interestRateIndex -> _interestRateIndex.getAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRateIndexInterestRateAssetClass {
	
		@Override
		public ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex interestRateIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION);
		}
	}
}
