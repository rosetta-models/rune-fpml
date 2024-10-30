package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradePackage;
import fpml.confirmation.validation.TradePackageTypeFormatValidator;
import fpml.confirmation.validation.TradePackageValidator;
import fpml.confirmation.validation.exists.TradePackageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradePackage.class)
public class TradePackageMeta implements RosettaMetaData<TradePackage> {

	@Override
	public List<Validator<? super TradePackage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradePackage>create(fpml.confirmation.validation.datarule.TradePackageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradePackage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradePackage> validator() {
		return new TradePackageValidator();
	}

	@Override
	public Validator<? super TradePackage> typeFormatValidator() {
		return new TradePackageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradePackage, Set<String>> onlyExistsValidator() {
		return new TradePackageOnlyExistsValidator();
	}
}
